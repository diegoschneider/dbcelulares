package com.diegoschneider.dbcelulares.clients;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.diegoschneider.dbcelulares.BaseTableModel;

public class ClientTableModel extends BaseTableModel implements TableModelListener {
	
	private static final long serialVersionUID = 9127782344420636795L;
	
	public ClientTableModel() {
		columnNames = new String[] {"ID", "Nombre","Apellido"};
		data = new Object[][] {{0,"Hi2","dsa"},{1,"dsa","asd"}};
		oldData = new Object[][] {{0,"Hi2","dsa"},{1,"dsa","asd"}};
		addTableModelListener(this);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int col = e.getColumn();
		System.out.println("Edit!");
		System.out.println("Old: "+oldData[row][col]);
		System.out.println("New: "+getValueAt(row,col));
	}
	
	
	
}
