package com.diegoschneider.dbcelulares;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlaceHolderPanel extends JPanel {
	
	private static final long serialVersionUID = -9045820577313414342L;
	private static int instances = 0;
	
	public PlaceHolderPanel() {
		instances++;
		switch(instances) {
			case(1): {
				add(new JLabel("Placeholder :3"));
				break;
			}
			case(2): {
				add(new JLabel("Otro placeholder :v"));
				break;
			}
			default: {
				add(new JLabel("Ya hay "+instances+" placeholders (^w^)"));
				break;
			}
		}
	
	}
	
}
