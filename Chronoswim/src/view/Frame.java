package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControlPanel controlPanel;
	private MainPanel mainPanel;
	private Image bgImage, frameIcon;

	public Frame() {

		this.bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/pool_bg.png")).getImage();
		this.frameIcon = new ImageIcon(getClass().getClassLoader().getResource("images/stopwatch.png")).getImage();
		this.controlPanel = new ControlPanel(bgImage);
		this.mainPanel = new MainPanel(bgImage);		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Chronoswim");
		this.setIconImage(frameIcon);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(223, 239, 255));
		
		getContentPane().add(controlPanel, BorderLayout.NORTH);
		getContentPane().add(mainPanel, BorderLayout.WEST);
		
		this.pack();
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
