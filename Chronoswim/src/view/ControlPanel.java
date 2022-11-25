package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class ControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSwimmers, panelRace;
	private JLabel lblRaceName, lblRaceDate;
	private JTextField txtAthlete1, txtAthlete2, txtAthlete3, txtAthlete4, 
						txtAthlete5, txtAthlete6, txtAthlete7, txtAthlete8;
	private JTextField txtRaceName, txtRaceDate;
	private ArrayList<JTextField> txtAthletes;
	private JButton btnStart, btnClear, btnDemoData;
	
	public ControlPanel(Image bgImage) {
		
	    setPreferredSize(new Dimension(bgImage.getWidth(null), 180));
	    setBackground(new Color(223, 239, 255));
	    setLayout(null);
	    
		panelSwimmers = new JPanel();
		panelSwimmers.setBackground(new Color(223, 239, 255));
		panelSwimmers.setBorder(new TitledBorder(null, "Participantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSwimmers.setBounds(20, 100, 900, 66);
		panelSwimmers.setLayout(null);
		add(panelSwimmers);
		
		panelRace = new JPanel();
		panelRace.setBackground(new Color(223, 239, 255));
		panelRace.setBorder(new TitledBorder(
				null, "Opciones de carrera", TitledBorder.LEADING, TitledBorder.TOP, null, null
				)
		);
		panelRace.setBounds(20, 22, 900, 66);
		panelRace.setLayout(null);
		add(panelRace);
	    
		lblRaceName = new JLabel("Nombre:");
		lblRaceName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaceName.setBounds(20, 28, 50, 14);
		panelRace.add(lblRaceName);
		
		txtRaceName = new JTextField();
		txtRaceName.setBounds(80, 24, 130, 24);
		panelRace.add(txtRaceName);
		
		lblRaceDate = new JLabel("Fecha-hora:");
		lblRaceDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaceDate.setBounds(226, 28, 68, 14);
		panelRace.add(lblRaceDate);
		
		txtRaceDate = new JTextField();
		txtRaceDate.setBounds(304, 24, 90, 24);
		txtRaceDate.setHorizontalAlignment(SwingConstants.TRAILING);
		panelRace.add(txtRaceDate);
		
		btnStart = new JButton("Comenzar carrera");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(420, 24, 140, 24);
		panelRace.add(btnStart);
		
		btnClear = new JButton("Limpiar formulario");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.setBounds(580, 24, 140, 24);
		panelRace.add(btnClear);
		
		btnDemoData = new JButton("Usar Demo-Data");
		btnDemoData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDemoData.setBounds(740, 24, 140, 24);
		panelRace.add(btnDemoData);
		
		txtAthlete1 = new JTextField();
		txtAthlete1.setBounds(14, 24, 90, 24);
		panelSwimmers.add(txtAthlete1);
		
		txtAthlete2 = new JTextField();
		txtAthlete2.setBounds(125, 24, 90, 24);
		panelSwimmers.add(txtAthlete2);
		
		txtAthlete3 = new JTextField();
		txtAthlete3.setBounds(236, 24, 90, 24);
		panelSwimmers.add(txtAthlete3);
		
		txtAthlete4 = new JTextField();
		txtAthlete4.setBounds(350, 24, 90, 24);
		panelSwimmers.add(txtAthlete4);
		
		txtAthlete5 = new JTextField();
		txtAthlete5.setBounds(462, 24, 90, 24);
		panelSwimmers.add(txtAthlete5);
		
		txtAthlete6 = new JTextField();
		txtAthlete6.setBounds(574, 24, 90, 24);
		panelSwimmers.add(txtAthlete6);
		
		txtAthlete7 = new JTextField();
		txtAthlete7.setBounds(686, 24, 90, 24);
		panelSwimmers.add(txtAthlete7);
		
		txtAthlete8 = new JTextField();
		txtAthlete8.setBounds(798, 24, 90, 24);
		panelSwimmers.add(txtAthlete8);
		
		this.txtAthletes = new ArrayList<JTextField>(
				Arrays.asList(txtAthlete1, txtAthlete2, txtAthlete3, txtAthlete4, 
						txtAthlete5, txtAthlete6, txtAthlete7, txtAthlete8)
		);
		
	}
	
	public JTextField getTxtRaceName() {
		return txtRaceName;
	}

	public JTextField getTxtRaceDate() {
		return txtRaceDate;
	}

	public JButton getBtnStart() {
		return btnStart;
	}
	
	public JButton getBtnClear() {
		return btnClear;
	}
	
	public JButton getBtnDemoData() {
		return btnDemoData;
	}

	public JTextField getTxtAthlete1() {
		return txtAthlete1;
	}

	public JTextField getTxtAthlete2() {
		return txtAthlete2;
	}

	public JTextField getTxtAthlete3() {
		return txtAthlete3;
	}

	public JTextField getTxtAthlete4() {
		return txtAthlete4;
	}

	public JTextField getTxtAthlete5() {
		return txtAthlete5;
	}

	public JTextField getTxtAthlete6() {
		return txtAthlete6;
	}

	public JTextField getTxtAthlete7() {
		return txtAthlete7;
	}

	public JTextField getTxtAthlete8() {
		return txtAthlete8;
	}

	/**
	 * @return All athletes names JTextField objects in the form
	 */
	public ArrayList<JTextField> getAllTxtAthletes() {
		return txtAthletes;
	}
	
	/**
	 * Clears every athlete name JTextField in the form
	 */
	public void clearFormFields() {
		this.txtRaceName.setText("");
		for (JTextField txtAthlete : txtAthletes) {
			txtAthlete.setText("");
		}
	}
	
	/**
	 * Sects the race information fields and buttons enabled/disabled
	 * when a race starts and ends.
	 * 
	 * @param enabledStatus boolean for the enabled/disabled status of the objects
	 */
	public void enableRaceConfiguration(boolean enabledStatus) {
		for (JTextField txtAthlete : txtAthletes) {
			txtAthlete.setEnabled(enabledStatus);
		}
		this.txtRaceName.setEnabled(enabledStatus);
		this.btnStart.setEnabled(enabledStatus);
		this.btnClear.setEnabled(enabledStatus);
		this.btnDemoData.setEnabled(enabledStatus);
	}
	
	/**
	 * Sets a red background color to a JTextField in the form
	 * for validation purposes.
	 * 
	 * @param the form JTextField
	 */
	public void setFieldRed(JTextField field) {
		field.setBackground(new Color(255, 223, 223));
	}
	
	/**
	 * Sets a normal white background color to a JTextField in the form
	 */
	public void setFieldsWhite() {
		for (JTextField txtAthlete : txtAthletes) {
			txtAthlete.setBackground(Color.WHITE);
		}
	}

}
