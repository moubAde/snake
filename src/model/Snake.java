package model;

import java.util.ArrayList;
import java.util.List;

public class Snake extends Observable {

	private final int INITSIZE = 30;

	private List<Coordinate> body = new ArrayList<>();
	private Game game;
	private Direction direction;
	private boolean alive = true;

	public void SetBody(List<Coordinate> a) {
		body=a;
	}
	
	public List<Coordinate> getBody() {
		System.out.println("taile:"+body.size());
		return body;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Snake(Game game) {
		this.game = game;
		registerObserver(game);
		direction = Direction.Right;
		Coordinate start = Coordinate.getRandomCoordinate(game);
		for (int i = 0; i < INITSIZE; i++) {
			Coordinate c = new Coordinate(start.getX() + i, start.getY());
			body.add(c);
			addChange(new Change(c, Change.ChangeType.SNAKE));
		}
	}

	public void move(Apple apple) {
		Coordinate last = body.get(body.size() - 1);
		Coordinate next = new Coordinate(last.getX() + direction.x, last.getY() + direction.y);
		//Trou
		//Enregistrement des changements
		addChange(new Change(body.get(0), Change.ChangeType.VOID));
		addChange(new Change(next, Change.ChangeType.SNAKE));
		
		this.body.remove(body.get(0));//retirer le coordonne de la queu
		this.body.add(next);// j ajoute un coordonne a la tete
		game.changeSnakeDirection(getDirection());
		//apres chaque deplacement on verifie si le snake peut continué et on previent ces observateurs
		if(game.isOut(next)==true){
		   this.alive=false;
		}		
		if(next.getX()==apple.getCoordinate().getX() && next.getY()==apple.getCoordinate().getY()){
			apple.appearance(this);
		}
		//je dois mettre alive a false s il ce mort la queu aussi 
		//notification aux observateurs 
		this.notifyObserver();
		//////////////////////////////////////////////
		
	}

	public boolean isAlive() {
		return alive;
	}

}
