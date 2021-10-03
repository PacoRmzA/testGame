package com.TheCubicJedi.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	LinkedList<Coin> coins = new LinkedList<Coin>();
			
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
			}
		for(int j = 0; j<coins.size(); j++) {
			Coin tempCoin = coins.get(j);
			tempCoin.tick();
		}	
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
			}
		for(int j = 0; j<coins.size(); j++) {
			Coin tempCoin = coins.get(j);
			tempCoin.render(g);
		}
	}
	
	public void addCoin(Coin coin) {
		this.coins.add(coin);
	}
	
	public void removeCoin(Coin coin) {
		this.coins.remove(coin);
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
		
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
