package loggerForms.scansappnmea;

import NMEA.NMEAControl;
import NMEA.NMEAPlugin;
import NMEA.NMEAProvider;

/**
 * The SCANS Android app can generate and send NMEA data to a PAMGuard PC 
 * over the network. This plugin can work within the NMEA module and squirt 
 * those data into the standard NMEA/GPS processing chain. 
 */
public class SCANSNMEAPlugin implements NMEAPlugin {

	String jarFile;
	
	@Override
	public String getDefaultName() {
		return "SCANS App NMEA";
	}

	@Override
	public String getHelpSetName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJarFile(String jarFile) {
		this.jarFile = jarFile;
	}

	@Override
	public String getJarFile() {
		return jarFile;
	}

	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		return "Doug Gillespie";
	}

	@Override
	public String getContactEmail() {
		return "pamguard@pamguard.org";
	}

	@Override
	public String getVersion() {
		return "0.0";
	}

	@Override
	public String getPamVerDevelopedOn() {
		return "2.02.19";
	}

	@Override
	public String getPamVerTestedOn() {
		return "2.02.19";
	}

	@Override
	public String getAboutText() {
		return "NMEA from phone";
	}

	@Override
	public NMEAProvider getNMEAProvider(NMEAControl nmeaControl) {
		return new SCANSAppNMEA(nmeaControl);
	}


}
