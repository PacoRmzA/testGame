package com.TheCubicJedi.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	
	private boolean isCoin;

	private float alpha = 1;
	private float life;
	
	private Handler handler;
	private Color color;
	
	private int width, height;
	
	public Trail(int x, int y, ID id, int width, int height, float life, Color color, Handler handler, boolean isCoin, HUD hud) {
		super(x, y, id, handler, hud);
		this.color = color;
		this.width = width;
		this.height = height;
		this.handler = handler;
		this.life = life;
		this.id = id;
		this.isCoin = isCoin;
	}

	public void tick() {
		if(alpha > life){
			alpha -= life - 0.0001f;
		} else {
			handler.removeObject(this);
		}
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		
		if(isCoin) {
			g.fillOval((int)x, (int)y, width, height);
		} else {
			g.fillRect((int)x, (int)y, width, height);
		}
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {
		return null;
	}

}
