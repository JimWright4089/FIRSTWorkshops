package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.configuration.annotations.I2cDeviceType;
import com.qualcomm.robotcore.util.TypeConversion;

@SuppressWarnings({"WeakerAccess", "unused"}) // Ignore access and unused warnings

@I2cDeviceType
@DeviceProperties(name = "LIDARLiteV4 Sensor", description = "an LIDARLiteV4 sensor", xmlTag = "LIDARLiteV4")
public class LIDARLiteV4 extends I2cDeviceSynchDevice<I2cDeviceSynch>
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Registers and Config Settings
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public enum Register
    {
      FIRST(0x00),
      ACQ_COMMANDS(0x00),
      STATUS(0x01),
      ACQUISITION_COUNT(0x05),
      FULL_DELAY_LOW(0x10),
      FULL_DELAY_HIGH(0x11),
      UNIT_ID_0(0x16),
      UNIT_ID_1(0x17),
      UNIT_ID_2(0x18),
      UNIT_ID_3(0x19),
      I2C_SEC_ADDR(0x1A),
      I2C_CONFIG(0x1B),
      DETECTION_SENSITIVITY(0x1C),
      LIB_VERSION(0x30),
      CORR_DATA(0x52),
      CP_VER_LO(0x72),
      CP_VER_HI(0x73), 
      BOARD_TEMPERATURE(0xE0),
      HARDWARE_VERSION(0xE1),
      POWER_MODE(0xE2),
      MEASUREMENT_INTERVAL(0xE3),
      FACTORY_RESET(0xE4),
      QUICK_TERMINATION(0xE5),
      START_BOOTLOADER(0xE6),
      ENABLE_FLASH_STORAGE(0xEA),
      HIGH_ACCURACY_MODE(0xEB),
      SOC_TEMPERATURE(0xEC),
      ENABLE_ANT_RADIO(0xF0),
      LAST(ENABLE_ANT_RADIO.bVal);

      public int bVal;

      Register(int bVal)
      {
          this.bVal = bVal;
      }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Construction and Initialization
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public final static I2cAddr ADDRESS_I2C_DEFAULT = I2cAddr.create7bit(0x62);

    public LIDARLiteV4(I2cDeviceSynch deviceClient, boolean deviceClientIsOwned)
    {
        super(deviceClient, deviceClientIsOwned);

        this.deviceClient.setI2cAddress(ADDRESS_I2C_DEFAULT);

        super.registerArmingStateCallback(false); // Deals with USB cables getting unplugged
        // Sensor starts off disengaged so we can change things like I2C address. Need to engage
        this.deviceClient.engage();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // User Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public short getDistance()
    {
      // 1. Trigger a range measurement.
      takeRange();

      // 2. Wait for busyFlag to indicate the device is idle.
      if(true == waitForBusy())
      {
        return readDistance();
      }

      return 0xffff;
    }

    public void takeRange()
    {
      byte dataByte = 0x04;

      write(Register.ACQ_COMMANDS, dataByte);
    }

    boolean waitForBusy()
    {
        byte busyFlag = 0x1;
        short timeOutCount = 200;

        do
        {
            busyFlag = getBusyFlag();

            timeOutCount--;
            if(0 == timeOutCount)
            {
              return false;
            }

        } while (busyFlag != 0);

        return true;
    } 

    byte getBusyFlag()
    {
        byte statusByte = 0;
        byte busyFlag; // busyFlag monitors when the device is done with a measurement

        // Read status register to check busy flag
        statusByte = read(Register.STATUS);

        // STATUS bit 0 is busyFlag
        busyFlag = (byte)(statusByte & 0x01);

        return busyFlag;
    } 

    /*------------------------------------------------------------------------------
      Read Distance

      Read and return the result of the most recent distance measurement.
    ------------------------------------------------------------------------------*/
    short readDistance()
    {
        short distance;
        distance = readShort(Register.FULL_DELAY_LOW);
        return distance; //This is the distance in centimeters
    } 

    /*------------------------------------------------------------------------------
      Get the temperature of the board
      
      Read the BOARD_TEMPERATURE register. This function returns the temperature in 
      two's complement in Celcius.
    ------------------------------------------------------------------------------*/
    byte getBoardTemp()
    {
        byte temp = 0;
        temp = read(Register.BOARD_TEMPERATURE);
        return temp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Read and Write Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////

    protected void writeShort(final Register reg, short value)
    {
        deviceClient.write(reg.bVal, TypeConversion.shortToByteArray(value));
    }

    protected short readShort(Register reg)
    {
        return TypeConversion.byteArrayToShort(deviceClient.read(reg.bVal, 2));
    }

    protected void write(final Register reg, byte value)
    {
        deviceClient.write8(reg.bVal, value);
    }

    protected byte read(Register reg)
    {
        return deviceClient.read8(reg.bVal);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Sub class methods
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected synchronized boolean doInitialize()
    {
      return true;
    }

    @Override
    public Manufacturer getManufacturer()
    {
        return Manufacturer.Adafruit;
    }

    @Override
    public String getDeviceName()
    {
        return "Garmin Lidar Lite V4 Sensor";
    }
}
