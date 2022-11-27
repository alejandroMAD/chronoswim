package controller;

import java.io.*;
import java.nio.charset.StandardCharsets;

import view.TablePanel;

/**
 * @author Alejandro M. Gonzalez
 *
 * A class to read the prestored demo data from a CSV file
 * within the resources folder of real races in the history
 * of the Olympic Games.
 *
 */
public class DemoDataReader {

	public static final String delimiter = "\\|";
	private static final String filePath = "/files/demodata.csv";
	private TablePanel tablePanel;
	private int linesCount;
	private int columnsCount;

	public DemoDataReader(TablePanel tablePanel) {
		this.tablePanel = tablePanel;
		this.linesCount = 0;
		this.columnsCount = this.tablePanel.getTable().getColumnCount();
		countLines();
	}

	/**
	 * Counts the number of entries present in the file of demo data
	 * within the resources folder
	 */
	public void countLines() {
		try (
				InputStream is = getClass().getResourceAsStream(filePath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			)
		{
			while (reader.readLine() != null) {
				linesCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the prestored demo data of races from a file within the resources folder
	 * 
	 * @return the two-dimensional String array of prestored demo data 
	 */
	public String[][] readDemoData() {

		try (
				InputStream is = getClass().getResourceAsStream(filePath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String[][] entriesArray = new String[(int) linesCount][(int) columnsCount];

			String line;
			String[] fieldsArray;
			int entry = 0;
			while ((line = br.readLine()) != null) {
				fieldsArray = line.split(delimiter);
				entriesArray[entry] = fieldsArray;
				entry++;
			}
			return entriesArray;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public long getLinesCount() {
		return linesCount;
	}

}
