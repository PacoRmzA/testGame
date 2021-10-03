package com.TheCubicJedi.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject extends Thread{
	
	protected float x, y;
	protected ID id;
	protected float velX, velY;
<<<<<<< HEAD
	protected Handler handler;
	protected HUD hud;
	
	public GameObject(float x, float y, ID id, Handler handler, HUD hud){
=======
	
	public GameObject(float x, float y, ID id){
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}

	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}

}
