package loggerForms.scansappnmea;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import PamView.dialog.PamDialogPanel;

public class SCANSAppDialogPanel implements PamDialogPanel {

	private SCANSAppNMEA scansAppNMEA;
	
	private JPanel mainPanel;

	public SCANSAppDialogPanel(SCANSAppNMEA scansAppNMEA) {
		this.scansAppNMEA = scansAppNMEA;
		mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder("SCANS App source"));
	}

	@Override
	public JComponent getDialogComponent() {
		return mainPanel;
	}

	@Override
	public void setParams() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getParams() {
		// TODO Auto-generated method stub
		return true;
	}

}
