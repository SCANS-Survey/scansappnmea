package loggerForms.scansappnmea;

import java.awt.Window;

import NMEA.NMEAControl;
import NMEA.NMEAProvider;
import PamView.dialog.PamDialogPanel;
import loggerForms.network.LoggerNetworkManager;
import loggerForms.network.LoggerNetworkMessage;
import loggerForms.network.LoggerNetworkReceiver;
import loggerForms.network.LoggerNetworkSystem;

/**
 * The SCANS Android app can generate and send NMEA data to a PAMGuard PC 
 * over the network. This plugin can work within the NMEA module and squirt 
 * those data into the standard NMEA/GPS processing chain. 
 */
public class SCANSAppNMEA extends NMEAProvider implements LoggerNetworkReceiver {

	public final String topic = "Logger/NMEA/#";
	private LoggerNetworkManager netManager;
	
	private long last;
	
	public SCANSAppNMEA(NMEAControl nmeaControl) {
		super(nmeaControl);
	}

	@Override
	public String getName() {
		return "SCANS App NMEA";
	}

	@Override
	public PamDialogPanel getDialogPanel(Window frame) {
		return new SCANSAppDialogPanel(this);
	}

	@Override
	public boolean startAcquisition() {
		stopAcquisition();
		netManager = LoggerNetworkSystem.getManager();
		netManager.subsribeTopic(topic,this);
		return false;
	}
	

	@Override
	public boolean newMessage(LoggerNetworkMessage message) {
		receivedData(message);
		return true;
	}

	protected void receivedData(LoggerNetworkMessage message) {
			try {
				/*
				 * Android can be a bit weird and if asked to provide updates too often sends a burst of them
				 * every 10s or so. Ignore updates that are < 800ms from one another. 
				 */
				long now = System.currentTimeMillis();
				if (now - last < 800) {
					return;
				}
				String str = new String(message.getData());
				StringBuffer sb = new StringBuffer(str);
				getNMEAProcess().addNewString(sb);
				System.out.printf("Time since previous loc is %d millis\n", now-last);
				last = now;
	//			System.out.println(str);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	@Override
	public void stopAcquisition() {
		if (netManager != null) {
			netManager.unsubscribeTopic(null, this);
		}

	}

}
