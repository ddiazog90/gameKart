package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface configurable {
	public final String ruta_play="src/data/play";
	public int turbo=2;
	
	public default void msg(JFrame view, String msg) {
		JOptionPane.showMessageDialog(view, msg);
	}

}
