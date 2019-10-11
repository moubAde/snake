package model;

import java.util.ArrayList;
import java.util.List;

import controller.GameObjectObserver;

public abstract class Observable {
	
	private ArrayList<Change> changes = new ArrayList<>();

	private ArrayList<GameObjectObserver> observers = new ArrayList<>();	
	
	protected void addChange(Change c) {
		this.changes.add( c );
	}
	
	public void registerObserver(GameObjectObserver observer) {
		this.observers.add( observer );
	}
	
	public void unregisterObserver(GameObjectObserver observer) {
		this.observers.remove( observer );
	}	

	public void notifyObserver() {
		List<Change> garde=this.getChanges();
		/*
		for(int i=0;i<observers.size();i++){
			observers.get(i).update(garde);
		}
		*/
		for(GameObjectObserver obs : observers){
			obs.update(garde);
		}
	}
	
	private List<Change> getChanges() {
		List<Change> result = new ArrayList<>(changes);
		changes.clear();
		return result;
	}
}
