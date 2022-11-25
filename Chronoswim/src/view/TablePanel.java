package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;

/**
 * @author Alejandro M. Gonzalez
 *
 */
public class TablePanel extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private Object[] row;
	private Icon goldMedal, silverMedal, bronzeMedal;

	public TablePanel() {

		this.table = new JTable();
		this.tableModel = new DefaultTableModel();
		this.row = new Object[5];
		this.setViewportView(table);
		
		goldMedal = new ImageIcon(getClass().getClassLoader().getResource("images/medal_gold.png"));
		silverMedal = new ImageIcon(getClass().getClassLoader().getResource("images/medal_silver.png"));
		bronzeMedal = new ImageIcon(getClass().getClassLoader().getResource("images/medal_bronze.png"));

		table.setBackground(new Color(223, 239, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.getTableHeader().setPreferredSize(new Dimension(this.getWidth(), 30));
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setIntercellSpacing(new Dimension(8, 0)); // Cell left-padding
		table.setRowHeight(28);

		Object[] columns = { "ID", "Nombre de la carrera", "Fecha-hora", "Oro", "Plata", "Bronce" };
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(180);
		
		// Customized JTable headers with icons
		// Reference private inner class JComponentTableCellRenderer below
		Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
		
		JLabel goldLabel = new JLabel(" Oro", goldMedal, JLabel.CENTER);
	    goldLabel.setBorder(headerBorder);
	    JLabel silverLabel = new JLabel(" Plata", silverMedal, JLabel.CENTER);
	    silverLabel.setBorder(headerBorder);
	    JLabel bronzeLabel = new JLabel(" Bronce", bronzeMedal, JLabel.CENTER);
	    bronzeLabel.setBorder(headerBorder);
	    
	    TableCellRenderer renderer = new JComponentTableCellRenderer();
	    TableColumnModel columnModel = table.getColumnModel();
	    
	    TableColumn column0 = columnModel.getColumn(3);
	    TableColumn column1 = columnModel.getColumn(4);
	    TableColumn column2 = columnModel.getColumn(5);

	    column0.setHeaderRenderer(renderer);
	    column0.setHeaderValue(goldLabel);
	    column1.setHeaderRenderer(renderer);
	    column1.setHeaderValue(silverLabel);
	    column2.setHeaderRenderer(renderer);
	    column2.setHeaderValue(bronzeLabel);
	}

	public void clearTable() {
		tableModel.setRowCount(0);
	}

	public Object[] getRow() {
		return row;
	}

	public void setRow(Object[] row) {
		this.row = row;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void addRow() {
		this.tableModel.addRow(row);
	}

	private class JComponentTableCellRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			return (JComponent) value;
		}
	}
}
