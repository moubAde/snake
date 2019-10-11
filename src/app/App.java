package app;

import javax.swing.JFrame;

import model.Game;
import view.Gui;

public class App {

	private static final int SCALE = 5;
	private static final int SPEED = 200;//25
	private static final int WIDTH = 100;
	private static final int HEIGTH = 100;

	public static void main(String[] args) {
		Game game = new Game(SPEED, WIDTH, HEIGTH);
		Gui.createGui(game, SCALE);
		game.run();
	}
}
