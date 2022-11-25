package model;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class SportsTimeFormat {
	
	private String formattedTime;
	
	/**
	 * Method to format a time of double type given in seconds
	 * and return a String with minutes, seconds and two decimal places
	 * for fractions of seconds, without applying any rounding,
	 * to be shown on the scoreboard with the format 00:00,00
	 * 
	 * @param a double value expressing time in seconds
	 * @return a formatted String
	 */
	public String getFormattedSportsTime(double seconds) {
		String secondsAsString = String.valueOf(seconds);
		
		// This concatenation prevents double values provided as argument
		// eventually having a single decimal place to throw a 
		// StringIndexOutOfBoundsException on the substring formatting below
		secondsAsString += "0";
		int indexOfSeparator = secondsAsString.indexOf(".");
		
		formattedTime = String.format("%02d:%02d,%s", 
				(int) ((seconds % 3600) / 60), 
				(int) seconds % 60,
				secondsAsString.substring(indexOfSeparator + 1, indexOfSeparator + 3)
		);

		return formattedTime;
	}

}
