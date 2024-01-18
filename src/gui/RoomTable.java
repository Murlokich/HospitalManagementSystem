package gui;

import javax.swing.table.AbstractTableModel;


public class RoomTable extends AbstractTableModel {
	final private String[] columnNames = {"Number", "Floor", "Available beds", "Capacity", "Dr."};
	private Object[][] data;
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
        return data.length;
    }
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	@Override
	public Object getValueAt(int row, int col) {
        return data[row][col];
    }
	
	@Override
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	
	public RoomTable(Object[][] data) {
		this.data = data;
	}
}
