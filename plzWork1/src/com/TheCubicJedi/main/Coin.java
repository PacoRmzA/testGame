package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Coin extends GameObject {
	
	private Handler handler;
	private int coinLevel = 1;
	

	public Coin(float x, float y, ID id, Handler handler, int coinLevel) {
		super(x, y, id);
		
		this.handler = handler;
		this.coinLevel = coinLevel;
		
		Random r = new Random();
		velX = r.nextInt(10);
		velY = r.nextInt(10);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16); 
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 64) velY*= -1;
		if(x <= 0 || x >= Game.WIDTH - 20) velX*= -1;
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, 16, 16, 0.05f, Color.orange, handler, true));
	}

	public void render(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillOval((int) x, (int) y, 16, 16);
		
	}

	public int getCoinLevel() {
		return coinLevel;
	}
	
	public void setCoinLevel(int coinLevel) {
		this.coinLevel = coinLevel;
	}
	
	
}
