import java.util.ArrayList;

//----------------------------------------------------------------------------
//
//  $Workfile: StopWatch.java$
//
//  $Revision: X$
//
//  Project:    PNW Code Wright
//
//                            Copyright (c) 2018
//                                Jim Wright
//                            All Rights Reserved
//
//  Modification History:
//  $Log:
//  $
//
//----------------------------------------------------------------------------

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: StopWatch
//
//Purpose:
//  This handles timeouts
//
//----------------------------------------------------------------------------
public class StopWatch 
{
  //----------------------------------------------------------------------------
  //  Class Consts
  //----------------------------------------------------------------------------
  final int ONE_SECOND = 1000;
  
  //----------------------------------------------------------------------------
  //  Class Attributes 
  //----------------------------------------------------------------------------
  long mLastTime = 0;
  int mWaitTime = 0;
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Constructor with default of one second 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public StopWatch()
  {
    mWaitTime = ONE_SECOND;
  }

  // --------------------------------------------------------------------
  // Purpose:
  //     Constructor with waitTime 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public StopWatch(int waitTime)
  {
    mWaitTime = waitTime;
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Change the time the stopwatch waits. 
  // 
  // Notes:
  //     This may do wierd things if the watch is counting
  // --------------------------------------------------------------------
  public void setTime(int waitTime)
  {
    mWaitTime = waitTime;
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     returns true is the time has finished counting 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public boolean isExpired()
  {
    if((now()-mLastTime)>mWaitTime)
    {
      return true;
    }
    return false;
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Reset the time back to zero 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public void reset()
  {
    mLastTime = System.currentTimeMillis(); 
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Returns the ms left in the count 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public long timeLeft()
  {
    return mWaitTime - (now()-mLastTime);
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Returns the ms from the system 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public static long now()
  {
    return System.currentTimeMillis();
  }
  
  // --------------------------------------------------------------------
  // Purpose:
  //     Simple main 
  // 
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public static void main(String[] args) 
  {
    StopWatch testWatch = new StopWatch();
    
    testWatch.reset();
    
    for(long i=0;i<80000;i++)
    {
      System.out.print(i);
      System.out.print(" ");
      System.out.print(testWatch.isExpired());
      System.out.print(" ");
      System.out.print(testWatch.timeLeft());
      System.out.print(" ");
      System.out.println(StopWatch.now());
    }
  }
}