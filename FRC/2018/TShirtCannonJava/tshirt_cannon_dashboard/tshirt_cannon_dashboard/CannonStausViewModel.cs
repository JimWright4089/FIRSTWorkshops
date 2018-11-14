using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FRCDash.MVVM;

[assembly: DBBindableType(typeof(tshirt_cannon_dashboard.CannonStatusViewModel))]

namespace tshirt_cannon_dashboard
{
    public class CannonStatusViewModel : BindableBase
    {
        private DBModel model;


        private bool cannonStatus;

        [DBProperty("charged")]
        public bool CannonStatus
        {
            set
            {
                SetProperty(ref cannonStatus, value);
            }
            get
            {
                return cannonStatus;
            }
        }

        public CannonStatusViewModel()
        {
            model = new DBModel(this);
        }
    }
}
