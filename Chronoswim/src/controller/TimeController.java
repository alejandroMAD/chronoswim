package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Race;
import model.SportsTimeFormat;
import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class TimeController implements ActionListener {
	
	private Frame frame;
	private Race race;
	private SportsTimeFormat sportsTimeFormat;
	private Timer raceTimeReading;

	public TimeController(Frame frame, Race race, SportsTimeFormat stf) {
		this.frame = frame;
		this.race = race;
		this.sportsTimeFormat = stf;
		// The refresh rate of the race clock in milliseconds
		this.raceTimeReading = new Timer(50, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		long currentTime = System.nanoTime();
		double clockTime = ((float) currentTime / 1_000_000_000) - ((float) race.getStartTime() / 1_000_000_000);
		this.frame.getMainPanel().getLblRaceTime().setText(sportsTimeFormat.getFormattedSportsTime(clockTime));
	}

	public Timer getTimeReading() {
		return raceTimeReading;
	}

}
