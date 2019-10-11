package model;

import java.util.ArrayList;
import java.util.List;

public class Apple extends Observable{

	private Coordinate bodyApple;
	private Game game;

	public Apple(Game game) {
		this.game = game;
		registerObserver(game);
	}
	
	public void initiale(){
		this.bodyApple = Coordinate.getRandomCoordinate(game);
		addChange(new Change(bodyApple, Change.ChangeType.SNAKE));
		this.notifyObserver();
	}
	public void appearance(Snake snake) {
		Coordinate next = Coordinate.getRandomCoordinate(game);
		//Trou
		//Enregistrement des changements
		addChange(new Change(bodyApple, Change.ChangeType.SNAKE));
		addChange(new Change(next, Change.ChangeType.SNAKE));
		this.bodyApple=next; 
		
		List<Coordinate> body = new ArrayList<>();
		body=snake.getBody();
		Coordinate c; 
		if(snake.getDirection()==Direction.Up || snake.getDirection()==Direction.Down){
			c= new Coordinate(body.get(body.size()-1).getX(), body.get(body.size()-1).getY()+1);
		}
		else{
			c= new Coordinate(body.get(body.size()-1).getX()+1, body.get(body.size()-1).getY());
		}
		body.add(c);
		snake.SetBody(body);
		this.notifyObserver();
		//agrandir le serpent
		//////////////////////////////////////////////
		
	}
	
	public Coordinate getCoordinate(){
		return this.bodyApple;
	}
}
