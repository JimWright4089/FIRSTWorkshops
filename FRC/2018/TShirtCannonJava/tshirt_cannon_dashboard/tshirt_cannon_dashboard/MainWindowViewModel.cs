using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FRCDash.MVVM;

[assembly: DBBindableType(typeof(tshirt_cannon_dashboard.MainWindowViewModel))]

namespace tshirt_cannon_dashboard
{
    public class MainWindowViewModel : BindableBase
    {
        private DBModel model;

        private const double kDistanceSlope = 2.1644;
        private const double kDistanceIntercept = 43.5345;

        private double onboardPressure;

        [DBProperty("PressureOut")]
        public double OnboardPressure
        {
            set
            {
                SetProperty(ref onboardPressure, value);
            }
            get
            {
                return onboardPressure;
            }
        }


        private double targetPressure;

        [DBProperty("PressureIn")]
        public double TargetPressure
        {
            set
            {
                if(SetProperty(ref targetPressure, value))
                {
                    TargetDistance = kDistanceSlope * value - kDistanceIntercept;
                }
            }
            get
            {
                return targetPressure;
            }
        }


        private double onboardDistance;

        [DBProperty("OnboardDistance")]
        public double OnboardDistance
        {
            set
            {
                SetProperty(ref onboardDistance, value);
            }
            get
            {
                return onboardDistance;
            }
        }

        private double targetDistance;

        [DBProperty("TargetDistance")]
        public double TargetDistance
        {
            set
            {
                if(SetProperty(ref targetDistance, value))
                {
                    TargetPressure = (value + kDistanceIntercept) / kDistanceSlope;
                }
            }
            get
            {
                return targetDistance;
            }
        }


        private bool isEnabled;

        [DBProperty("IsEnabled")]
        public bool IsEnabled
        {
            set
            {
                SetProperty(ref isEnabled, value);
            }
            get
            {
                return isEnabled;
            }
        }

        public MainWindowViewModel()
        {
            model = new DBModel(this);
            TargetPressure = 40;
        }
    }
}
