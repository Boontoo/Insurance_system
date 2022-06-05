package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private JLabel label;
	
	public MainPanel() {
		this.label = new JLabel();
		this.add(label);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		this.label.setText("aaaa");
	}
	
	
	
}
