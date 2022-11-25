package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image bgImage;
	private Icon stopIcon;
	private TablePanel tablePanel;
	private JButton stop1, stop2, stop3, stop4, stop5, stop6, stop7, stop8,
					btnAddRace, btnDeleteRace, btnUpdateRace;
	private JLabel lblRaceTime, lblTime1, lblTime2, lblTime3, 
					lblTime4, lblTime5, lblTime6, lblTime7, lblTime8;
	private ArrayList<JButton> stopButtons;
	private ArrayList<JLabel> timeLabels;
	
	public MainPanel(Image bgImage) {
		
		this.bgImage = bgImage;
		this.stopIcon = new ImageIcon(getClass().getClassLoader().getResource("images/stop_icon.png"));
		Dimension size = new Dimension(bgImage.getWidth(null), bgImage.getHeight(null));
		setPreferredSize(size);
		setSize(size);
		setLayout(null);
		
		stop1 = new JButton(stopIcon);
		stop1.setBounds(51, 46, 50, 50);
		this.add(stop1);
		
		stop2 = new JButton(stopIcon);
		stop2.setBounds(164, 46, 50, 50);
		this.add(stop2);
		
		stop3 = new JButton(stopIcon);
		stop3.setBounds(276, 46, 50, 50);
		this.add(stop3);
		
		stop4 = new JButton(stopIcon);
		stop4.setBounds(389, 46, 50, 50);
		this.add(stop4);
		
		stop5 = new JButton(stopIcon);
		stop5.setBounds(501, 46, 50, 50);
		this.add(stop5);
		
		stop6 = new JButton(stopIcon);
		stop6.setBounds(614, 46, 50, 50);
		this.add(stop6);
		
		stop7 = new JButton(stopIcon);
		stop7.setBounds(726, 46, 50, 50);
		this.add(stop7);
		
		stop8 = new JButton(stopIcon);
		stop8.setBounds(838, 46, 50, 50);
		this.add(stop8);
		
		this.stopButtons = new ArrayList<JButton>(
				Arrays.asList(stop1, stop2, stop3, stop4, stop5, stop6, stop7, stop8)
		);
		
		lblTime1 = new JLabel("00:00,00");
		lblTime1.setForeground(Color.WHITE);
		lblTime1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime1.setBounds(38, 174, 84, 30);
		add(lblTime1);
		
		lblTime2 = new JLabel("00:00,00");
		lblTime2.setForeground(Color.WHITE);
		lblTime2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime2.setBounds(150, 174, 84, 30);
		add(lblTime2);
		
		lblTime3 = new JLabel("00:00,00");
		lblTime3.setForeground(Color.WHITE);
		lblTime3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime3.setBounds(262, 174, 84, 30);
		add(lblTime3);
		
		lblTime4 = new JLabel("00:00,00");
		lblTime4.setForeground(Color.WHITE);
		lblTime4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime4.setBounds(375, 174, 84, 30);
		add(lblTime4);
		
		lblTime5 = new JLabel("00:00,00");
		lblTime5.setForeground(Color.WHITE);
		lblTime5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime5.setBounds(488, 174, 84, 30);
		add(lblTime5);
		
		lblTime6 = new JLabel("00:00,00");
		lblTime6.setForeground(Color.WHITE);
		lblTime6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime6.setBounds(600, 174, 84, 30);
		add(lblTime6);
		
		lblTime7 = new JLabel("00:00,00");
		lblTime7.setForeground(Color.WHITE);
		lblTime7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime7.setBounds(712, 174, 84, 30);
		add(lblTime7);
		
		lblTime8 = new JLabel("00:00,00");
		lblTime8.setForeground(Color.WHITE);
		lblTime8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime8.setBounds(825, 174, 84, 30);
		add(lblTime8);
		
		this.timeLabels = new ArrayList<JLabel>(
				Arrays.asList(lblTime1, lblTime2, lblTime3, lblTime4, lblTime5, lblTime6, lblTime7, lblTime8)
		);
		
		lblRaceTime = new JLabel("00:00,00");
		lblRaceTime.setOpaque(true);
		lblRaceTime.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		lblRaceTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaceTime.setForeground(Color.BLACK);
		lblRaceTime.setBackground(new Color(223, 239, 255));
		lblRaceTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRaceTime.setBounds(405, 230, 130, 35);
		add(lblRaceTime);
		
		btnAddRace = new JButton("Añadir registro");
		btnAddRace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddRace.setBounds(400, 300, 140, 24);
		add(btnAddRace);
		
		tablePanel = new TablePanel();
		tablePanel.setBounds(50, 354, 840, 240);
		add(tablePanel);
		
		btnDeleteRace = new JButton("Eliminar registro");
		btnDeleteRace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteRace.setBounds(300, 624, 140, 24);
		add(btnDeleteRace);
		
		btnUpdateRace = new JButton("Modificar registro");
		btnUpdateRace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdateRace.setBounds(500, 624, 140, 24);
		add(btnUpdateRace);
		
	}
	
	public void paintComponent(Graphics g) {
	    g.drawImage(bgImage, 0, 0, null);
	}

	public JButton getStop1() {
		return stop1;
	}

	public JButton getStop2() {
		return stop2;
	}

	public JButton getStop3() {
		return stop3;
	}

	public JButton getStop4() {
		return stop4;
	}

	public JButton getStop5() {
		return stop5;
	}

	public JButton getStop6() {
		return stop6;
	}

	public JButton getStop7() {
		return stop7;
	}

	public JButton getStop8() {
		return stop8;
	}
	
	/**
	 * @return all the JButton objects to stop race competitors times
	 */
	public ArrayList<JButton> getAllStopButtons() {
		return stopButtons;
	}
	
	public JLabel getLblTime1() {
		return lblTime1;
	}
	
	public JLabel getLblTime2() {
		return lblTime2;
	}

	public JLabel getLblTime3() {
		return lblTime3;
	}

	public JLabel getLblTime4() {
		return lblTime4;
	}

	public JLabel getLblTime5() {
		return lblTime5;
	}

	public JLabel getLblTime6() {
		return lblTime6;
	}

	public JLabel getLblTime7() {
		return lblTime7;
	}

	public JLabel getLblTime8() {
		return lblTime8;
	}

	public ArrayList<JLabel> getAllTimeLabels() {
		return timeLabels;
	}
	
	public JLabel getLblRaceTime() {
		return lblRaceTime;
	}

	public TablePanel getTablePanel() {
		return tablePanel;
	}

	public JButton getBtnAddRace() {
		return btnAddRace;
	}

	public JButton getBtnDeleteRace() {
		return btnDeleteRace;
	}

	public JButton getBtnUpdateRace() {
		return btnUpdateRace;
	}

	/**
	 * Changes de state of the race clock stop buttons to enabled/disabled
	 * when the race starts and ends.
	 * 
	 * @param enabledStatus the state enabled/disabled of the JButton objects
	 */
	public void enableStopButtons(boolean enabledStatus) {
		for (JButton stopButton : stopButtons) {
			stopButton.setEnabled(enabledStatus);
		}
	}

}
