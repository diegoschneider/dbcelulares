package com.diegoschneider.dbcelulares;

import javax.swing.table.AbstractTableModel;

public class BaseTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -120383990831901869L;

	protected String[] columnNames = {};
	protected Object[][] data = {{}};
	protected Object[][] oldData = {{}};
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		oldData[row][col] = data[row][col];
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col].toString();
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if(getColumnName(col).equalsIgnoreCase("ID")) {
			return false;
		} else {
			return true;
		}
	}
	
}
