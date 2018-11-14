using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;
using FRCDash.MVVM;

namespace tshirt_cannon_dashboard
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        private void Application_Startup(object sender, StartupEventArgs e)
        {
            const int team = 1039;
            NTUtil.StartMDNSDash(team);
            //Or use roborio ip address

            //local host
            //NTUtil.StartIPDash("127.0.0.1"); 
        }

        private void Application_Exit(object sender, ExitEventArgs e)
        {
            NTUtil.Shutdown();
        }
    }
}
