package model;

import java.util.List;

import controller.GameObjectObserver;
import model.Change.ChangeType;

public class Game extends Observable implements GameObjectObserver {

	private int sleep=1000;
	private int height;
	private int width;
	private Snake snake;
	private Apple apple;
	

	public Game(int sleep, int width, int height) {
		//Trou
	    this.sleep=sleep;
	    this.width=width;
	    this.height=height;
	    apple=new Apple(this);
	    snake=new Snake(this);
	    /////////////////////////////////////////
	}

	@Override
	public void update(List<? extends Change> changes) {
		//Trou
	    //enregistrer les changements
		for(Change c:changes){
		   addChange(c);
		}
		//Prevenir ses observaeurs qu'une modification a été effectué 
		this.notifyObserver();
		//////////////////////////////////////////////////
	}
	
	public void changeSnakeDirection(Direction direction) {
		snake.setDirection(direction);
	}
	
	public boolean isOut(Coordinate c) {
		if (c.getX() < 0 || c.getY() < 0)
			return true;
		if (c.getX() >= width || c.getY() >= height)
			return true;
		return false;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

	/*public void step() {
	    //Trou
		//Definir la direction dans laquelle le serpend bouge
		//Direction direction=new Direction();
		//effectuer le deplacement
		snake.move();
		//verifier si on doit continuer
		if(snake.isAlive()==true){ 
		   //definir les changements effectue s'il est en vie
		   this.addChange(new Change(new Coordinate(0,0),Change.ChangeType.SNAKE));
		   //prevenir ces observateurs que des changements ont été effectue
		   this.notifyObserver();
		   try{
				Thread.sleep(sleep);
			}
			catch(InterruptedException e){
				System.err.println("imposible");
			}
		   step();
		}
		else{
		   //definir les changements effectue s'il n'est plus en vie 
		   this.addChange(new Change(new Coordinate(10,10),Change.ChangeType.VOID));
		   //prevenir ces observateurs que des changements ont été effectue
		   this.notifyObserver();
		}
		///////////////////////////////////
	}*/

	public void run() {
	    //Trou
	    //this.step();
		apple.initiale();
		while(snake.isAlive()==true){
		  snake.move(apple);
		  try{
				Thread.sleep(sleep);
				//System.out.println("dormir");
		  }
		  catch(InterruptedException e){
				System.err.println("imposible");
		  }
		  //snake.notifyObserver();
		}
		////////////////////////////////////////
	}

}
