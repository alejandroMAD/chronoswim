package controller;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import model.Race;
import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class RaceController implements ActionListener {

	private Frame frame;
	private Race race;
	private TimeController timeController;
	private boolean filledInformation;

	public RaceController(Frame frame, Race race, TimeController timeController) {
		this.frame = frame;
		this.race = race;
		this.timeController = timeController;
		this.filledInformation = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		race.reset();
		setRaceInformation();
		
		if (e.getSource().equals(frame.getControlPanel().getBtnClear())) {
			frame.getControlPanel().clearFormFields();
			frame.getControlPanel().setFieldsWhite();
		} else {
			if (filledInformation) {
				if (e.getSource().equals(frame.getControlPanel().getBtnStart())) {
					race.setStartTime(System.nanoTime());
					timeController.getTimeReading().start();
					frame.getControlPanel().enableRaceConfiguration(false);
					frame.getControlPanel().setFieldsWhite();
					frame.getMainPanel().enableStopButtons(true);
					frame.getMainPanel().getBtnAddRace().setEnabled(false);
					for (JLabel timeLabel : this.frame.getMainPanel().getAllTimeLabels()) {
						timeLabel.setText("");
					}
	
					this.frame.repaint();
				}
			} else if (e.getSource().equals(frame.getControlPanel().getBtnDemoData())) {
				frame.getControlPanel().getTxtRaceName().setText("Beijing 100m Butterfly Final");
				frame.getControlPanel().getTxtAthlete1().setText("Takuro Fujii");
				frame.getControlPanel().getTxtAthlete2().setText("Jason Dunford");
				frame.getControlPanel().getTxtAthlete3().setText("Andrew Lauterstein");
				frame.getControlPanel().getTxtAthlete4().setText("Milorad Cavic");
				frame.getControlPanel().getTxtAthlete5().setText("Michael Phelps");
				frame.getControlPanel().getTxtAthlete6().setText("Ian Crocker");
				frame.getControlPanel().getTxtAthlete7().setText("Andriy Serdinov");
				frame.getControlPanel().getTxtAthlete8().setText("Ryan Pini");
				frame.getControlPanel().setFieldsWhite();
			} else {
				JOptionPane.showMessageDialog(frame, "Debe inscribir a 8 atletas", "Advertencia",JOptionPane.WARNING_MESSAGE);			
			}
		}
	}

	/**
	 * Validates the race information form and sets filledInformation true
	 * if all race competitors fields are completed. Race name field isn't
	 * required ("Default Race" name will be used if empty) and the race date
	 * is automatically generated.
	 * 
	 */
	public void setRaceInformation() {
		this.filledInformation = true;
		frame.getControlPanel().setFieldsWhite();
		
		if (!frame.getControlPanel().getTxtRaceName().getText().isEmpty()) {
			race.setName(frame.getControlPanel().getTxtRaceName().getText());			
		}

		race.setDate(frame.getControlPanel().getTxtRaceDate().getText());
		
		race.setLane1Name(frame.getControlPanel().getTxtAthlete1().getText());
		race.setLane2Name(frame.getControlPanel().getTxtAthlete2().getText());
		race.setLane3Name(frame.getControlPanel().getTxtAthlete3().getText());
		race.setLane4Name(frame.getControlPanel().getTxtAthlete4().getText());
		race.setLane5Name(frame.getControlPanel().getTxtAthlete5().getText());
		race.setLane6Name(frame.getControlPanel().getTxtAthlete6().getText());
		race.setLane7Name(frame.getControlPanel().getTxtAthlete7().getText());
		race.setLane8Name(frame.getControlPanel().getTxtAthlete8().getText());

		for (JTextField txtAthlete : frame.getControlPanel().getAllTxtAthletes()) {
			if (txtAthlete.getText().isEmpty()) {
				this.filledInformation = false;
				txtAthlete.setBackground(new Color(255, 223, 223));
			}
		}
	}
}
