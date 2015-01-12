package com.diegoschneider.dbcelulares;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.diegoschneider.dbcelulares.clients.ClientPanel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 5300305653276587645L;
	Dimension minimumSize = new Dimension(450,300);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		DBManager.connect();
		if(DBManager.isConnected()) {
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
		} else {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			System.exit(0);
		}
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.err.println("Usando LookNFeel original");
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(true);
		setMinimumSize(minimumSize);
		setSize(minimumSize);
		setLocation(100, 100);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(WindowEvent winEvt) {
	        	int result = JOptionPane.showConfirmDialog(null, "Estás seguro que deseas salir?", "!!!", JOptionPane.YES_NO_OPTION);
	        	if(result == JOptionPane.YES_OPTION) {
	        		System.exit(0);
	        	}
	            
	        }
	    });
		
		JTabbedPane contentPane = new JTabbedPane();
		setContentPane(contentPane);
		
		contentPane.addTab("Inicio", new PlaceHolderPanel());
		contentPane.addTab("Clientes", new ClientPanel());
		contentPane.addTab("Presupuestos", new PlaceHolderPanel());
	}
}
