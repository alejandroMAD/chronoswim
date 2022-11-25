package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import model.Race;
import model.SportsTimeFormat;
import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class StopController extends AbstractAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private Race race;
	private SportsTimeFormat sportsTimeFormat;
	private TimeController timeController;
	private int stops;

	public StopController(Frame frame, Race race, SportsTimeFormat stf, TimeController timeController) {
		this.frame = frame;
		this.race = race;
		this.sportsTimeFormat = stf;
		this.stops = 0;
		this.timeController = timeController;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		long stopTime = System.nanoTime();
		stops++;
		
		if (e.getSource().equals(frame.getMainPanel().getStop1())) {
			race.setLane1Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane1Name());
			this.frame.getMainPanel().getLblTime1().setText(
						sportsTimeFormat.getFormattedSportsTime(race.getLane1Time())
			);
			this.frame.getMainPanel().getStop1().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop2())) {
			race.setLane2Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane2Name());
			this.frame.getMainPanel().getLblTime2().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane2Time())
			);
			this.frame.getMainPanel().getStop2().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop3())) {
			race.setLane3Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane3Name());
			this.frame.getMainPanel().getLblTime3().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane3Time())
			);
			this.frame.getMainPanel().getStop3().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop4())) {
			race.setLane4Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane4Name());
			race.getRaceRanking().put(stops, race.getLane4Name());
			this.frame.getMainPanel().getLblTime4().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane4Time())
			);
			this.frame.getMainPanel().getStop4().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop5())) {
			race.setLane5Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane5Name());
			this.frame.getMainPanel().getLblTime5().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane5Time())
			);
			this.frame.getMainPanel().getStop5().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop6())) {
			race.setLane6Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane6Name());
			this.frame.getMainPanel().getLblTime6().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane6Time())
			);
			this.frame.getMainPanel().getStop6().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop7())) {
			race.setLane7Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane7Name());
			this.frame.getMainPanel().getLblTime7().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane7Time())
			);
			this.frame.getMainPanel().getStop7().setEnabled(false);
		} else if (e.getSource().equals(frame.getMainPanel().getStop8())) {
			race.setLane8Time(stopTime);
			race.getRaceRanking().put(stops, race.getLane8Name());
			this.frame.getMainPanel().getLblTime8().setText(
					sportsTimeFormat.getFormattedSportsTime(race.getLane8Time())
			);
			this.frame.getMainPanel().getStop8().setEnabled(false);
		}
		
		// Actions to take when the race ends (all 8 stops are registered)
		if (this.stops == 8) {
			timeController.getTimeReading().stop();
			race.createRaceNamesTimes();
			frame.getControlPanel().enableRaceConfiguration(true);
			frame.getControlPanel().getBtnStart().setText("Nueva carrera");
			frame.getMainPanel().getBtnAddRace().setEnabled(true);;
			stops = 0;
			System.out.println(race);
		}	
		
		this.frame.repaint();
	}

}
