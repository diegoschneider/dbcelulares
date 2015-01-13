package com.diegoschneider.dbcelulares;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class BaseTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -120383990831901869L;

	protected ArrayList<String> columnNames = new ArrayList<String>();
	protected ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
	
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		if(!value.equals(data.get(row).get(col))) {
			data.get(row).set(col, value);
		} else {
			System.out.println("same");
		}
    }
		
	@Override
	public String getColumnName(int col) {
        return columnNames.get(col).toString();
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if(getColumnName(col).equalsIgnoreCase("ID")) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addRow(ArrayList<Object> newData) {
		data.add(newData);
		fireTableRowsInserted(data.size()-1, data.size()-1);
	}
	
	public void addRow(Object[] newData) {
		addRow(new ArrayList<Object>(Arrays.asList(newData)));
	}
}
