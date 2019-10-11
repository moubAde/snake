package view;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Game;

public class Gui {
	
	public static JFrame createGui(Game game, int scale) {
		return createGui(0,0,game,scale);
	}
	
	public static JFrame createGui(int x,int y,Game game, int scale) {
		GamePanel gamePanel;
		InfosJeu infosJeu;
		Role role;
		gamePanel = new GamePanel(game, scale);
		infosJeu=new InfosJeu();
		role=new Role(game);	
		JFrame frame = new JFrame("Snake");
		gamePanel = new GamePanel(game, scale);
		
		frame.setLayout(new BorderLayout());
		frame.add(infosJeu,BorderLayout.NORTH);
		frame.add(gamePanel,BorderLayout.CENTER);
		frame.add(role,BorderLayout.SOUTH);
		
		frame.add(gamePanel);
		frame.pack();
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
		gamePanel.requestFocusInWindow();
		frame.setVisible(true);
		return frame;
	}

}
