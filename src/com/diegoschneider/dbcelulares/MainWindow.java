package com.diegoschneider.dbcelulares;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.h2.jdbcx.JdbcDataSource;

public class MainWindow extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
