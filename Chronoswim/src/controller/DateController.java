package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Timer;

import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class DateController implements ActionListener {

	private Frame frame;
	private Timer dateTimeReading;

	public DateController(Frame frame) {
		this.frame = frame;
		// System date and time is checked every 30 seconds
		this.dateTimeReading = new Timer(30_000, this);
		dateTimeReading.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.getControlPanel().getTxtRaceDate().setText(getFormattedDateTime());
	}

	public Timer getTimeReading() {
		return dateTimeReading;
	}

	public String getFormattedDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
        		"dd/MM/yy-HH:mm"
		);
		return LocalDateTime.now().format(formatter);

	}

}
