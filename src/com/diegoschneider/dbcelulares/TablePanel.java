package com.diegoschneider.dbcelulares;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import com.diegoschneider.dbcelulares.clients.ClientTableModel;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = -9178958309647138514L;
	protected JTable table = new JTable();
	
	public TablePanel(String objective) {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0};
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		setTableModel(new ClientTableModel());
		
		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		gbc_scrollPane.gridwidth = 3;
		add(scrollPane, gbc_scrollPane);
		
		JButton btnAdd = new JButton("Agregar "+objective);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAction();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		add(btnAdd, gbc_btnAdd);
		
		JButton btnEdit = new JButton("Editar "+objective);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					editAction();
				}
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 1;
		add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Eliminar "+objective);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					deleteAction();
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 1;
		add(btnDelete, gbc_btnDelete);
		
	}
	
	public void setTableModel(TableModel model) {
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		
	}
	
	public void addAction() {
		System.out.println("Add");
	}
	
	public void editAction() {
		System.out.println("Edit");
	}
	
	public void deleteAction() {
		System.out.println("Delete");
	}
	
}
