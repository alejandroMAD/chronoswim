package model;

import java.util.*;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class Race {
	
	private String name;
	private String date;
	private String lane1Name, lane2Name, lane3Name, lane4Name,
					lane5Name, lane6Name, lane7Name, lane8Name;
	private long startTime;
	private double lane1Time, lane2Time, lane3Time, lane4Time, 
				lane5Time, lane6Time, lane7Time, lane8Time;
	private HashMap<String, String> raceNamesTimes;
	private HashMap<Integer, String> raceRanking;
	private SportsTimeFormat sportsTimeFormat;
	
	public Race() {
		this.name = "Default Race";
		this.raceNamesTimes = new HashMap<String, String>();
		this.raceRanking = new HashMap<Integer, String>();
		this.sportsTimeFormat = new SportsTimeFormat();

	}

	@Override
	public String toString() {
		return "Race [name=" + name + ", date=" + date + "]"
				+ ",\nlane1Name=" + lane1Name + ", lane2Name=" + lane2Name 
				+ ", lane3Name=" + lane3Name + ", lane4Name=" + lane4Name
				+ ",\nlane5Name=" + lane5Name + ", lane6Name=" + lane6Name 
				+ ", lane7Name=" + lane7Name + ", lane8Name=" + lane8Name 
				+ "\n[startTime=" + startTime
				+ "]\nlane1Time=" + lane1Time + ", lane2Time=" + lane2Time 
				+ ", lane3Time=" + lane3Time + ", lane4Time=" + lane4Time 
				+ ",\nlane5Time=" + lane5Time + ", lane6Time=" + lane6Time
				+ ", lane7Time=" + lane7Time + ", lane8Time=" + lane8Time
				+ "\nraceNamesTimes=" + raceNamesTimes + "\nraceRanking=" + raceRanking;
	}

	/**
	 * Resets the race object basic information
	 */
	public void reset() {
		this.name = "Default Race";
		this.date = null;
		this.startTime = 0L;
	}
	

	/**
	 * Maps athletes names and their stop times at the end of a race
	 */
	public void createRaceNamesTimes() {
		raceNamesTimes.put(lane1Name, sportsTimeFormat.getFormattedSportsTime(lane1Time));
		raceNamesTimes.put(lane2Name, sportsTimeFormat.getFormattedSportsTime(lane2Time));
		raceNamesTimes.put(lane3Name, sportsTimeFormat.getFormattedSportsTime(lane3Time));
		raceNamesTimes.put(lane4Name, sportsTimeFormat.getFormattedSportsTime(lane4Time));
		raceNamesTimes.put(lane5Name, sportsTimeFormat.getFormattedSportsTime(lane5Time));
		raceNamesTimes.put(lane6Name, sportsTimeFormat.getFormattedSportsTime(lane6Time));
		raceNamesTimes.put(lane7Name, sportsTimeFormat.getFormattedSportsTime(lane7Time));
		raceNamesTimes.put(lane8Name, sportsTimeFormat.getFormattedSportsTime(lane8Time));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLane1Name() {
		return lane1Name;
	}

	public void setLane1Name(String lane1Name) {
		this.lane1Name = lane1Name;
	}

	public String getLane2Name() {
		return lane2Name;
	}

	public void setLane2Name(String lane2Name) {
		this.lane2Name = lane2Name;
	}

	public String getLane3Name() {
		return lane3Name;
	}

	public void setLane3Name(String lane3Name) {
		this.lane3Name = lane3Name;
	}

	public String getLane4Name() {
		return lane4Name;
	}

	public void setLane4Name(String lane4Name) {
		this.lane4Name = lane4Name;
	}

	public String getLane5Name() {
		return lane5Name;
	}

	public void setLane5Name(String lane5Name) {
		this.lane5Name = lane5Name;
	}

	public String getLane6Name() {
		return lane6Name;
	}

	public void setLane6Name(String lane6Name) {
		this.lane6Name = lane6Name;
	}

	public String getLane7Name() {
		return lane7Name;
	}

	public void setLane7Name(String lane7Name) {
		this.lane7Name = lane7Name;
	}

	public String getLane8Name() {
		return lane8Name;
	}

	public void setLane8Name(String lane8Name) {
		this.lane8Name = lane8Name;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public double getLane1Time() {
		return lane1Time;
	}

	public void setLane1Time(double lane1Time) {
		this.lane1Time = (lane1Time - this.startTime) / 1_000_000_000;
	}

	public double getLane2Time() {
		return lane2Time;
	}

	public void setLane2Time(double lane2Time) {
		this.lane2Time = (lane2Time - this.startTime) / 1_000_000_000;
	}

	public double getLane3Time() {
		return lane3Time;
	}

	public void setLane3Time(double lane3Time) {
		this.lane3Time = (lane3Time - this.startTime) / 1_000_000_000;
	}

	public double getLane4Time() {
		return lane4Time;
	}

	public void setLane4Time(double lane4Time) {
		this.lane4Time = (lane4Time - this.startTime) / 1_000_000_000;
	}

	public double getLane5Time() {
		return lane5Time;
	}

	public void setLane5Time(double lane5Time) {
		this.lane5Time = (lane5Time - this.startTime) / 1_000_000_000;
	}

	public double getLane6Time() {
		return lane6Time;
	}

	public void setLane6Time(double lane6Time) {
		this.lane6Time = (lane6Time - this.startTime) / 1_000_000_000;
	}

	public double getLane7Time() {
		return lane7Time;
	}

	public void setLane7Time(double lane7Time) {
		this.lane7Time = (lane7Time - this.startTime) / 1_000_000_000;
	}

	public double getLane8Time() {
		return lane8Time;
	}

	public void setLane8Time(double lane8Time) {
		this.lane8Time = (lane8Time - this.startTime) / 1_000_000_000;
	}

	/**
	 * @return the HashMap mapping athletes names and their stop times
	 */
	public HashMap<String, String> getRaceNamesTimes() {
		return raceNamesTimes;
	}

	/**
	 * @return the HashMap mapping order of arrival and athletes names
	 */
	public HashMap<Integer, String> getRaceRanking() {
		return raceRanking;
	}	
	
}
