package com.diegoschneider.dbcelulares;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.h2.jdbcx.JdbcDataSource;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 5300305653276587645L;
	Dimension minimumSize = new Dimension(450,300);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JdbcDataSource ds = new JdbcDataSource();
		ds.setUrl("jdbc:h2:./dbcelulares;ifexists=true");
		ds.setUser("sa");
		ds.setPassword("sa");
		Connection conn;
		try {
			conn = ds.getConnection();
			System.out.println("DB existente");
		} catch (SQLException e1) {
			//DB Inexistente
			if(e1.getErrorCode() == 90013) {
				try {
					System.out.println("Creando bd");
					ds.setUrl("jdbc:h2:./dbcelulares");
					conn = ds.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				e1.printStackTrace();
			}
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			//e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setMinimumSize(minimumSize);
		setSize(minimumSize);
		setLocation(100, 100);
		
		JTabbedPane contentPane = new JTabbedPane();
		setContentPane(contentPane);
		
		contentPane.addTab("Inicio", new PlaceHolderPanel());
		contentPane.addTab("Clientes", new PlaceHolderPanel());
		contentPane.addTab("Presupuestos", new PlaceHolderPanel());
	}
}
