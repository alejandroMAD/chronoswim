package controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import view.TablePanel;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class DemoDataReader {

	public static final String delimiter = "\\|"; 
	private static final String filePath = "demodata.csv";
	private String[][] demoEntries;
	private TablePanel tablePanel;
	private File file;
	private long linesCount;
	private int columnsCount;

	public DemoDataReader(TablePanel tablePanel) {
		this.tablePanel = tablePanel;
		this.file = new File(filePath);
		demoEntries = new String[][] {
                {
                	"1",
                	"Beijing 100m Butterfly Final", 
                	"16/08/08-10:10", 
                	"Michael Phelps (00:50,58)", 
                	"Milorad Cavic (00:50,59)", 
                	"Ian Crocker (00:51,12)"
            	}, 
                {
                	"2",
                	"Paris 100m Freestyle Final", 
                	"20/07/24-15:00", 
                	"Johnny Weissmuller (00:59,00)", 
                	"Duke Kahanamoku (01:01,40)", 
                	"Samuel Kahanamoku (01:01,80)"
            	},
                {
                	"3",
                	"Rio de Janerio 200m Butterfly Final", 
                	"10/08/16-18:35", 
                	"Mireia Belmonte (02:04,85)", 
                	"Madeline Groves (02:04,88)", 
                	"Natsumi Hoshi (02:05,20)"
            	},
                {
                	"4",
                	"Barcelona 50m Freestyle Final", 
                	"30/07/92-20:30", 
                	"Alexander Popov (00:21,91)", 
                	"Matt Biondi (00:22,09)", 
                	"Tom Jager (00:22,30)"
            	}, 
                {
                	"5",
                	"London 200m Butterfly Final", 
                	"31/07/12-19:49", 
                	"Chad le Clos (01:52,96)", 
                	"Michael Phelps (01:53,01)", 
                	"Takeshi Matsuda (01:53,21)"
            	}
              };
		
		this.linesCount = demoEntries.length;
		this.columnsCount = this.tablePanel.getTable().getColumnCount();
		
		writeDemoData();
	}
	
	public void writeDemoData() {

		try (
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
				BufferedWriter bw = new BufferedWriter(osw);
			) {
			for (String[] entry : demoEntries) {
				for (int i = 0; i < columnsCount; i++) {
					bw.append(String.valueOf(entry[i]));
					
					// Appends comma between values and new line after the last value
					if (i < columnsCount - 1) {
						bw.append(delimiter.replace("\\", ""));
					} else if (i == columnsCount - 1) {
						bw.append("\n");
					}
				}				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns the records of races demo data
	 * 
	 * @return the records of races demo data
	 */
	public String[][] readDemoData() {

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

	public long getLinesCount() {
		return linesCount;
	}

	public String[][] getDemoEntries() {
		return demoEntries;
	}
	
}
