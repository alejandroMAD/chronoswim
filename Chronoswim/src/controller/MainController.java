package controller;

import javax.swing.*;

import view.Frame;
import model.Race;
import model.SportsTimeFormat;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class MainController {
	
	private Frame frame;
	private TimeController timeController;
	private DateController dateController;
	private RaceController raceController;
	private StopController stopController;
	private DatabaseController databaseController;
	private CsvReaderWriter csvRW;
	private DemoDataReader demoDR;
	
	public MainController(Race race, SportsTimeFormat stf, Frame frame) {
		this.frame = frame;
		this.timeController = new TimeController(frame, race, stf);
		this.dateController = new DateController(frame);
		this.raceController = new RaceController(frame, race, timeController);
		this.stopController = new StopController(frame, race, stf, timeController);
		this.csvRW = new CsvReaderWriter(frame.getMainPanel().getTablePanel());
		this.demoDR = new DemoDataReader(frame.getMainPanel().getTablePanel());
		this.databaseController = new DatabaseController(frame, race, csvRW, demoDR);
		
		initView();
		initControllers();
	}
	
	public void initView() {
		this.frame.getControlPanel().getTxtRaceDate().setText(dateController.getFormattedDateTime());
		this.frame.getControlPanel().getTxtRaceDate().setEnabled(false);
		this.frame.getMainPanel().enableStopButtons(false);
		this.frame.getMainPanel().getBtnAddRace().setEnabled(false);
		
	}
	
	public void initControllers() {
		this.frame.getControlPanel().getBtnStart().addActionListener(raceController);
		this.frame.getControlPanel().getBtnClear().addActionListener(raceController);
		this.frame.getControlPanel().getBtnDemoData().addActionListener(raceController);

		for (JButton stopButton : this.frame.getMainPanel().getAllStopButtons()) {
			stopButton.addActionListener(stopController);
		}
		
		this.frame.getMainPanel().getBtnAddRace().addActionListener(databaseController);
		this.frame.getMainPanel().getBtnDeleteRace().addActionListener(databaseController);
		this.frame.getMainPanel().getBtnUpdateRace().addActionListener(databaseController);
	}
		
}
