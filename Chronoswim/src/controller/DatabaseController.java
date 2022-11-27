package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.Race;
import view.Frame;

/**
 * @author Alejandro M. Gonzalez
 *
 * A class to manage the records of data from races.
 * Names, date-time, participants and ranking of races are showed
 * in the JTable view and stored in a CSV file in the working directory,
 * so DatabaseController both manages the basic CRUD operations in this file
 * and updates the view while handling the events of the add, delete
 * and update buttons.
 * 
 */
public class DatabaseController implements ActionListener {
	
	private Frame frame;
	private Race race;
	private CsvReaderWriter csvReaderWriter;
	private DemoDataReader demoDataReader;
	private int lastID;

	public DatabaseController(
			Frame frame, Race race, CsvReaderWriter csvRW, DemoDataReader demoDR
	) {
		this.frame = frame;
		this.race = race;
		this.csvReaderWriter = csvRW;
		this.demoDataReader = demoDR;
		this.lastID = (int) csvReaderWriter.getLinesCount();
		
		if (lastID > 0) {
			populateTableFromCsv();			
		} else {
			createDemoData();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			
		if (e.getSource().equals(frame.getMainPanel().getBtnAddRace())) {
			Object[] entry = new Object[] {
					this.lastID + 1,
					race.getName(),
					race.getDate(),
					race.getRaceRanking().get(1) + " (" 
							+ race.getRaceNamesTimes().get(race.getRaceRanking().get(1)) + ")", 
					race.getRaceRanking().get(2) + " (" 
							+ race.getRaceNamesTimes().get(race.getRaceRanking().get(2)) + ")",
					race.getRaceRanking().get(3) + " (" 
							+ race.getRaceNamesTimes().get(race.getRaceRanking().get(3)) + ")"
			};
			csvReaderWriter.writeCsv(entry);
			frame.getMainPanel().getTablePanel().setRow(entry);
			frame.getMainPanel().getTablePanel().addRow();
		} else if (e.getSource().equals(frame.getMainPanel().getBtnDeleteRace())) {
			int row = frame.getMainPanel().getTablePanel().getTable().getSelectedRow();
			if (row >= 0) {
				csvReaderWriter.deleteFromCsv(row);
				frame.getMainPanel().getTablePanel().getTableModel().removeRow(row);
				frame.getMainPanel().getTablePanel().getTableModel().setRowCount(1);
				frame.getMainPanel().getTablePanel().clearTable();
				populateTableFromCsv();
			} else {
				JOptionPane.showMessageDialog(
						frame,
						"Debe seleccionar un registro de la tabla para eliminarlo",
						"Chronoswim - Eliminar",
						JOptionPane.WARNING_MESSAGE
				);
			}
		} else if (e.getSource().equals(frame.getMainPanel().getBtnUpdateRace())) {
			int row = frame.getMainPanel().getTablePanel().getTable().getSelectedRow();
			if (row >= 0) {
				String newName = JOptionPane.showInputDialog(
						frame, 
						"Escribe el nombre de la carrera para modificar el registro actual: ", 
						"Chronoswim - Modificar", 
						JOptionPane.QUESTION_MESSAGE
				);
				csvReaderWriter.updateCsvEntry(row, newName);
				frame.getMainPanel().getTablePanel().getTableModel().setValueAt(newName, row, 1);
				frame.getMainPanel().getTablePanel().clearTable();
				populateTableFromCsv();
			} else {
				JOptionPane.showMessageDialog(
						frame,
						"Debe seleccionar un registro de la tabla para modificar su nombre",
						"Chronoswim - Modificar",
						JOptionPane.WARNING_MESSAGE
				);
			}
		}
		
		this.lastID = (int) csvReaderWriter.getLinesCount();
	}
	
	/**
	 * Populates the JTable view with records of races from the CSV file
	 */
	public void populateTableFromCsv() {
		
		String[][] entriesArray = csvReaderWriter.readCsv();
		for (String[] entry : entriesArray) {
			frame.getMainPanel().getTablePanel().setRow(entry);
			frame.getMainPanel().getTablePanel().addRow();	
		}
	}
	
	/**
	 * Populates the JTable view with a set of records of demo data
	 * if there isn't any records yet, and add the demo entries to the CSV file
	 */
	public void createDemoData() {
		String[][] demoEntries = demoDataReader.readDemoData();
		for (String[] demoEntry : demoEntries) {
			csvReaderWriter.writeCsv(demoEntry);
		}
		for (String[] demoEntry : demoEntries) {
			frame.getMainPanel().getTablePanel().setRow(demoEntry);
			frame.getMainPanel().getTablePanel().addRow();	
		}
	}
}
