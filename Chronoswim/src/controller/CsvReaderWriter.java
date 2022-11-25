package controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import view.TablePanel;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class CsvReaderWriter {

	public static final String delimiter = "\\|"; 
	// pipe is a regex metacharacter and needs to be escaped
	private static final String filePath = "chronoswim.csv";
	private TablePanel tablePanel;
	private File file;
	private long linesCount;
	private int columnsCount;

	public CsvReaderWriter(TablePanel tablePanel) {
		this.tablePanel = tablePanel;
		this.file = new File(filePath);
		
		if (file.exists()) {
			this.linesCount = countLines();
		}
		this.columnsCount = this.tablePanel.getTable().getColumnCount();			
	}

	public long countLines() {
		try (
			Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
			) 
		{
			return stream.count();
		} catch (IOException e) {
			e.printStackTrace();
			return 0L;
		}
	}
	
	public void clearCsv() {
		try (
				FileOutputStream fos = new FileOutputStream(file, false);
				OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
				BufferedWriter bw = new BufferedWriter(osw);
			) 
		{
			bw.write("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCsv(Object[] fields) {

		try (
				FileOutputStream fos = new FileOutputStream(file, true);
				OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
				BufferedWriter bw = new BufferedWriter(osw);
			) {
			for (int i = 0; i < columnsCount; i++) {
				bw.append(String.valueOf(fields[i]));

				// Appends comma between values and new line after the last value
				if (i < columnsCount - 1) {
					bw.append(delimiter.replace("\\", ""));
				} else if (i == columnsCount - 1) {
					bw.append("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Recount needs to happen after try-with-resources block so the flush + (auto)close have occurred
		this.linesCount = countLines();
	}

	public String[][] readCsv() {

		try (
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
			) 
		{
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
	
	public void deleteFromCsv(int row) {
		String[][] oldEntries = readCsv();
		String[][] updatedEntries = new String[oldEntries.length - 1][(int) columnsCount];
		
		int newIndex = 1;
		for (int i = 0; i < oldEntries.length; i++) {
			if (i < row) {
				updatedEntries[i] = (oldEntries[i]);
				updatedEntries[i][0] = String.valueOf(newIndex);
				newIndex++;		
			} else if (i > row) {
				updatedEntries[i - 1] = (oldEntries[i]);
				updatedEntries[i - 1][0] = String.valueOf(newIndex);
				newIndex++;		
			}
		}
		
		clearCsv();
		linesCount = 0;
		for (String[] updatedEntry : updatedEntries) {
			writeCsv(updatedEntry);
		}
	}
	
	public void updateCsvEntry(int row, String newName) {
		String[][] oldEntries = readCsv();
		String[][] updatedEntries = new String[oldEntries.length][(int) columnsCount];
		
		for (int i = 0; i < oldEntries.length; i++) {
			updatedEntries[i] = oldEntries[i];			
			if (i == row) {
				updatedEntries[i][1] = newName;
			}
		}
		
		clearCsv();
		linesCount = 0;
		for (String[] updatedEntry : updatedEntries) {
			writeCsv(updatedEntry);
		}
	}

	public long getLinesCount() {
		return linesCount;
	}

}
