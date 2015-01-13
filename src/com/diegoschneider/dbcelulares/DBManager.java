package com.diegoschneider.dbcelulares;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.h2.jdbcx.JdbcDataSource;

public final class DBManager {
	
	private static Connection conn;
	
	private DBManager() {}
	
	/**
	 * Se conecta a la base de datos
	 */
	public static void connect() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setUrl("jdbc:h2:./dbcelulares;ifexists=true");
		ds.setUser("sa");
		ds.setPassword("sa");
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
			} 
			//DB en uso
			else if(e1.getErrorCode() == 90020) {
				JOptionPane.showMessageDialog(null, "Ya hay una instancia del programa abierta");
				System.exit(0);
			} else {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Checkea si está conectado a la BD
	 * @return boolean - Si está conectado
	 */
	public static boolean isConnected() {
		try {
			return conn.isValid(0);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @return Connección actual
	 */
	public static Connection getConnection() {
		return conn;
	}
	
}
