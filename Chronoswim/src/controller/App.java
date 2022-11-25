package controller;

import model.Race;
import model.SportsTimeFormat;
import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class App {

	public static void main(String[] args) {

		Race race = new Race();
		SportsTimeFormat stf = new SportsTimeFormat();
		
		Frame frame = new Frame();
		frame.setLocationRelativeTo(null);
		
		new MainController(race, stf, frame); 

	}
}
