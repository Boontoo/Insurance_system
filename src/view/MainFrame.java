package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainPanel mainPanel;
	
	
	public MainFrame() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//	utility
//		this.windowsHandler = new WindowsHandler();
//		this.addWindowListener(this.windowsHandler);
		
		//	components
//		this.pMenuBar = new PMenuBar();
//		this.setJMenuBar(this.pMenuBar);		
		
//		this.pToolBar = new PToolBar();
//		this.add(this.pToolBar, BorderLayout.NORTH);
		
		this.mainPanel = new MainPanel();
		this.add(this.mainPanel, BorderLayout.CENTER);
	}


	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.mainPanel.initialize();
	}
}
