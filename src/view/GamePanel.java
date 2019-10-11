package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.GameObjectObserver;
import model.Change;
import model.Direction;
import model.Game;

public class GamePanel extends JPanel implements GameObjectObserver {

	private final EnumMap<Change.ChangeType, Color> color;

	private static final long serialVersionUID = -746841458539162873L;

	private BufferedImage img;

	private int scale;
	

	public GamePanel(Game game, int scale) {
		this.setBackground(Color.YELLOW);
		this.scale = scale;
		int width = game.getWidth() * scale;
		int height = game.getHeight() * scale;
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		setPreferredSize(new Dimension(width, height));
		//game.registerObserver(/*Trou*/);
		game.registerObserver(this); 
		///////////////////////////////////////
		color = new EnumMap<>(Change.ChangeType.class);
		color.put(Change.ChangeType.SNAKE, Color.RED);
		color.put(Change.ChangeType.VOID, Color.BLACK);

		//addKeyListener( //Remplir en utilisant une classe anonyme implémentant KeyAdapter 
		//);
		addKeyListener(new KeyAdapter(){
										public void keyPressed(KeyEvent e){
										   int source=e.getKeyCode();
										   //System.out.println(e.getKeyCode());
										   if(source==KeyEvent.VK_UP){
											  System.out.println("UP"); 
											  game.changeSnakeDirection(Direction.Up);											  
										   }
										   if(source==KeyEvent.VK_DOWN){
											   System.out.println("DOWN");
											   game.changeSnakeDirection(Direction.Down);
										   }										  
										   if(source==KeyEvent.VK_LEFT){
											   System.out.println("LEFT");
											   game.changeSnakeDirection(Direction.Left);
										   }										   
										   if(source==KeyEvent.VK_RIGHT){
											   System.out.println("RIGTH");
											   game.changeSnakeDirection(Direction.Right);
										   }
										   if(source==32){
											   //mettre le jeu en pause
											   System.out.println("pause");
											   //game.sleep=1000*1200;
										   }
										   if(source==10){
											   //relancer le jeu
											   System.out.println("play");
											   //this.thread.start();
										   }
										}
										public void keyReleased(KeyEvent e){}
										public void keyTyped(KeyEvent e){}
					   }
		);
		////////////////////////////////////////////
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void update(List<? extends Change> o) {
		Graphics g = img.getGraphics();
		//Trou
		for(Change c:o ){
			g.setColor(color.get(c.getChangeType()));//donne une couleur au serpent.enum map est genre une table de hachage tu lui donne un nom il te donne la couleur
			g.drawOval(c.getCoordinate().getX()*scale,c.getCoordinate().getY()*scale,scale,scale);
		}
		/////////////////////////////////////////////
		g.dispose();
		repaint();
	}

}
