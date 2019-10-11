package view;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfosJeu extends JPanel {

	InfosJeu(){
		this.setBackground(Color.BLUE);
		this.add(new JLabel("entree"));
		this.add(new JTextField("/"));
		this.add(new JLabel("relacher"));
		this.add(new JTextField(" "));
		this.add(new JLabel("sortie"));
		this.add(new JTextField("/"));
	}
}
