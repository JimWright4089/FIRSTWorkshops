package org.usfirst.frc1039.TShirtCannonJava;

public class PressureObject {
	private double psi;
	private double dist;
	
	//pressure
	private static final double kKpaConvert = 6.895;
	private static final double kBarConvert = 0.0689;
	
	//distance
	private static final double kYdConvert = 0.3333;
	private static final double kInConvert = 12.0;
	
	//volts
	/*

	Converting from volts to pressure

	72.519psi = 4.9V
	 0.000psi = 0.2V

	x=volts
	y=psi

	m = 72.519 / 4.5 = 16.115

	y - 0 = 16.115(x - 0.2)
	y = 16.115x - 3.223

	---------------------------

	Converting from pressure to volts (y inverse)

	x = 16.115y - 3.223
	y = (x + 3.223) / 16.115

	*/
	private static final double kVoltSlope = 16.115;
	private static final double kVoltIntercept = 3.223;
	
	//pressure to distance: kDistanceSlope * pressure - kDistanceIntercept
	//distance to pressure: (distance + kDistanceIntercept) / kDistanceSlope
	private static final double kDistanceSlope = 2.1644;
	private static final double kDistanceIntercept = 43.5345;
	
	public enum ValueType
	{
		Pressure, Distance
	}
	
	public PressureObject(double value, ValueType t)
	{
		switch(t)
		{
		case Pressure:
			this.psi = value;
			convertPressureToDistance();
			break;
		case Distance:
			this.dist = value;
			convertDistanceToPressure();
			break;
		}
	}
	
	public static double pressureToVolts(PressureObject psi)
	{
		return (psi.getPsi() + kVoltIntercept) / kVoltSlope;
	}
	
	public static PressureObject voltsToPressure(double volts)
	{
		return new PressureObject((kVoltSlope * volts) - kVoltIntercept, ValueType.Pressure);
	}
	
	private void convertPressureToDistance()
	{
		dist = kDistanceSlope * psi - kDistanceIntercept;
	}
	
	private void convertDistanceToPressure()
	{
		psi = (dist + kDistanceIntercept) / kDistanceSlope;
	}
	
	public double getPsi()
	{
		return psi;
	}
	
	public double getKpa()
	{
		return psi * kKpaConvert;
	}
	
	public double getBar()
	{
		return psi * kBarConvert;
	}
	
	public void setPsi(double val)
	{
		psi = val;
		convertPressureToDistance();
	}
	
	public void setKpa(double val)
	{
		psi = val / kKpaConvert;
		convertPressureToDistance();
	}
	
	public void setBar(double val)
	{
		psi = val / kBarConvert;
		convertPressureToDistance();
	}
	
	public double getFt()
	{
		return dist;
	}
	
	public double getIn()
	{
		return dist * kInConvert;
	}
	
	public double getYd()
	{
		return dist * kYdConvert;
	}
	
	public void setFt(double val)
	{
		dist = val;
		convertDistanceToPressure();
	}
	
	public void setIn(double val)
	{
		dist = val / kInConvert;
		convertDistanceToPressure();
	}
	
	public void setYd(double val)
	{
		dist = val / kYdConvert;
		convertDistanceToPressure();
	}
	
	@Override
	public String toString()
	{
		return psi + " psi";
	}
	
	public String toString(String format)
	{
		if (format.startsWith("d "))
		{
			if(format.contains("yd"))
			{
				return getYd() + " yds";
			}
			else if(format.contains("in"))
			{
				return getIn() + " inches";
			}
			return dist + " ft";
		}
		if (format.startsWith("p "))
		{
			if(format.contains("kpa"))
			{
				return getKpa() + " KPa";
			}
			else if(format.contains("bar"))
			{
				return getBar() + " Bar";
			}
			return psi + " psi";
		}
		return toString();
	}
}
