package org.usfirst.frc.team4444.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import org.opencv.core.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import org.opencv.core.Rect;
import org.opencv.core.Point;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DriverStation.Alliance;


import java.util.*;

/**
 * Uses the CameraServer class to automatically capture video from a USB webcam
 * and send it to the FRC dashboard without doing any vision processing. This
 * is the easiest way to get camera images to the dashboard. Just add this to the
 * robotInit() method in your program.
 */
public class Robot extends IterativeRobot {
	DigitalOutput mPinBlueOutput;
    DigitalOutput mPinRedOutput;
    DriverStation mDriversStation;
    Joystick mLeftStick;  // set to ID 1 in DriverStation

	public static final int kLeftMotor01 = 3;
	public static final int kLeftMotor02 = 4;
	public static final int kRightMotor01 = 1;
	public static final int kRightMotor02 = 2;
	public static final int kLeftEncoderA = 2;
	public static final int kLeftEncoderB = 3;
	public static final int kRightEncoderA = 0;
	public static final int kRightEncoderB = 1;
		
	public static CANTalon mLeftMotor01;
	public static CANTalon mLeftMotor02;
	public static CANTalon mRightMotor01;
	public static CANTalon mRightMotor02;
	public static double MAX_SPEED = 180.0;
	public static double SPEED_DENOM = 3.0;
	public static final int kWinchPWM = 9;

	public static Talon mWinchMotor01;
	
	I2C mI2C;
	byte[] mSendBytes = new byte[4];
	byte[] mReceiveBytes = new byte[10];
	DriverStation mStation = DriverStation.getInstance();	
	
	public static PowerDistributionPanel mPowerDistPanel;
	public double mSpeedLeft = 0;
	public double mSpeedRight = 0;

	public double mWhereToTurn = 0;

	@Override
	public void disabledInit() {
		SetLED();
	}
		
	@Override
	public void robotInit() {
		mPinBlueOutput = new DigitalOutput(9);
		mPinRedOutput = new DigitalOutput(8);
		mDriversStation = DriverStation.getInstance();
		mLeftMotor01 = new CANTalon(kLeftMotor01); // Initialize the CanTalonSRX on device 1.
		mLeftMotor02 = new CANTalon(kLeftMotor02); // Initialize the CanTalonSRX on device 1.
		mRightMotor01 = new CANTalon(kRightMotor01); // Initialize the CanTalonSRX on device 1.
		mRightMotor02 = new CANTalon(kRightMotor02); // Initialize the CanTalonSRX on device 1.		  
		mLeftStick = new Joystick(0);

		mI2C = new I2C(I2C.Port.kOnboard, 40);
		SetLED();
		
		mLeftMotor01.set(0);
		mLeftMotor02.changeControlMode(CANTalon.TalonControlMode.Follower);
		mLeftMotor02.set(kLeftMotor01);
		mRightMotor01.set(0);
		mRightMotor02.changeControlMode(CANTalon.TalonControlMode.Follower);
		mRightMotor02.set(kRightMotor01);
		
		mWinchMotor01 = new Talon(kWinchPWM);
		
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(320, 240);
            camera.setExposureManual(2);
            camera.setBrightness(2);
            camera.setWhiteBalanceManual(0);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream2 = CameraServer.getInstance().putVideo("Orig", 320, 240);
            //CvSource outputStream1 = CameraServer.getInstance().putVideo("Orig", 320, 240);
            
            int morphSize = 7;
            Mat imgOriginal = new Mat();
            Mat imgHSV = new Mat();
            Mat imgThresholded = new Mat();
            Mat imgThresholdedCopy = new Mat();
            Rect rct1 = new Rect();
            Rect rct2 = new Rect();
            
            while(true) {
                cvSink.grabFrame(imgOriginal);
                Imgproc.cvtColor(imgOriginal, imgHSV, Imgproc.COLOR_BGR2GRAY);
                //Imgproc.cvtColor(imgOriginal, imgHSV, Imgproc.COLOR_BGR2HSV); //Convert the captured frame from BGR to HSV
                Imgproc.threshold(imgHSV, imgThresholded, 30, 255, Imgproc.THRESH_BINARY);
                            
                //morphological opening (remove small objects from the foreground)
                Imgproc.erode(imgThresholded, imgThresholded, 
                		Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphSize, morphSize)));
                Imgproc.dilate(imgThresholded, imgThresholded, 
                		Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphSize, morphSize)));

                //morphological closing (fill small holes in the foreground)
                Imgproc.dilate(imgThresholded, imgThresholded, 
                		Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphSize, morphSize)));
                Imgproc.erode(imgThresholded, imgThresholded, 
                		Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphSize, morphSize)));
                 
                imgThresholded.copyTo(imgThresholdedCopy);
                
                List<MatOfPoint> contours = new Vector<MatOfPoint>(); 
                Mat hierarchy = new Mat();
                Imgproc.findContours(imgThresholdedCopy, contours, hierarchy, 
                		Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));
                //System.out.print("Size:");
                //System.out.println(contours.size());
                double largestArea1 = -1;
                int largestCont1 = -1;
                double largestArea2 = -1;
                int largestCont2 = -1;
                
                for (int i = 0; i< contours.size(); i++)
                {
                    double area = Imgproc.contourArea(contours.get(i));
                    {
                    if (area > largestArea1)
                    {
                        largestArea2 = largestArea1;
                        largestCont2 = largestCont1;
                        rct2 = rct1;
                    	
                        largestArea1 = area;
                        largestCont1 = i;
                        rct1 = Imgproc.boundingRect(contours.get(largestCont1));
                    }
                    else
                    {
                        if (area > largestArea2)
                        {
                            largestArea2 = area;
                            largestCont2 = i;
                            rct2 = Imgproc.boundingRect(contours.get(largestCont2));
                        }
                    }
                    }
                }

                if (-1 != largestCont1)
                {
                    MatOfPoint2f  mat = new MatOfPoint2f( contours.get(largestCont1).toArray() );
                    
                    Imgproc.approxPolyDP(mat, mat, 3, true);
 
                    Scalar color = new Scalar(0, 0, 255);
                    Imgproc.drawContours(imgOriginal, contours, largestCont1, color, 2, 8, hierarchy, 0, new Point());
                    Scalar color2 = new Scalar(255, 0, 0);
                    //Imgproc.rectangle(img, pt1, pt2, color2);
                    Imgproc.rectangle(imgOriginal, rct1.tl() ,rct1.br() , color2, 2);
                    
                    mWhereToTurn = rct1.tl().y-120; 

                    if (-1 != largestCont2)
                    {
                        //rct = Imgproc.boundingRect(contours.get(largestCont));
                        //contours.get
                        MatOfPoint2f  mat2 = new MatOfPoint2f( contours.get(largestCont2).toArray() );
                        //MatOfPoint2f mat = contours.get(largestCont);
                        
                        Imgproc.approxPolyDP(mat2, mat2, 3, true);
     
                        Scalar color3 = new Scalar(0, 255, 255);
                        Imgproc.drawContours(imgOriginal, contours, largestCont1, color3, 2, 8, hierarchy, 0, new Point());
                        Scalar color4 = new Scalar(255, 255, 0);
                        Imgproc.rectangle(imgOriginal, rct2.tl() ,rct2.br() , color4, 2);

                        int cx = ((rct1.x+(rct1.x+rct1.width))/2 + (rct2.x+(rct2.x+rct2.width))/2)/2;
                        int cy = ((rct1.y+(rct1.y+rct1.height))/2 + (rct2.y+(rct2.y+rct2.height))/2)/2;
                        
                        Scalar color5 = new Scalar(0, 255, 0);
                        Imgproc.circle(imgOriginal, new Point(cx,cy), 4, color5);
                        System.out.println(cx+" "+cy+" "+
                        rct1.x+" "+rct1.y+" "+
                        rct2.x+" "+rct2.y+" "+
                        rct1.width+" "+rct1.height+" "+
                        rct2.width+" "+rct2.height+" ");
                        
                        mWhereToTurn = rct1.tl().y-120; 
                        
                    }
                    
                    
                }
                else
                {
                	mWhereToTurn = 9999;
                }
                //System.out.print("Turn:");
                //System.out.println(mWhereToTurn);

                //outputStream2.putFrame(imgThresholded);
                outputStream2.putFrame(imgOriginal);
               
            }
            //Thread.sleep(10);
        }).start();
}

	@Override
	public void autonomousInit() {
		SetLED();
	}	
	
public void teleopInit()
{
	SetLED();		
}

/**
 * This function is called periodically during operator control
 */
@Override
public void teleopPeriodic() {
	
	mSpeedLeft = mLeftStick.getRawAxis(1);
	if((mSpeedLeft > -.1)&&(mSpeedLeft < .1))
	{
		mSpeedLeft = 0.0;
	}
	
	mSpeedRight = -mLeftStick.getRawAxis(5);
	if((mSpeedRight > -.1)&&(mSpeedRight < .1))
	{
		mSpeedRight = 0.0;
	}
	
	  	mLeftMotor01.set(mSpeedLeft/SPEED_DENOM);
	  	mRightMotor01.set(mSpeedRight/SPEED_DENOM);
	
  	  	if (mLeftStick.getRawAxis(3) > 0.5)
  	  	{
  	  		mWinchMotor01.set(1.0);
  	  		//System.out.println("right trig");
  	  		
  	  	} else if (mLeftStick.getRawAxis(2) > 0.5)
  	  	{
  	  		mWinchMotor01.set(-1.0);
  	  		//System.out.println("left trig");
  	  		
  	  	} else {
  	  		mWinchMotor01.set(0.0);
  	  	}

	  	
}

public void disabledPeriodic()
{
	SetLED();
}

// The ardiuno sets the color of the LED ring
// If the robot is disabled then spin the alliance color
// If it's enabled then show white LED
private void SetLED() {
	System.out.println("Send");
	if (Alliance.Blue == mStation.getAlliance()) {
		mSendBytes[0] = 'B';
	} else {
		if (Alliance.Red == mStation.getAlliance()) {
			mSendBytes[0] = 'R';
		} else {
			mSendBytes[0] = 'I';
		}
	}

	mSendBytes[1] = (byte) mStation.getLocation();
	if (true == mStation.isEnabled()) {
		mSendBytes[2] = 'E';
	} else {
		mSendBytes[2] = 'D';
	}
	mI2C.transaction(mSendBytes, 4, mReceiveBytes, 10);
}


}

