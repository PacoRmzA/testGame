package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject {

		
		private Handler handler;
		

		public Enemy(float x, float y, ID id, Handler handler) {
			super(x, y, id);
			
			this.handler = handler;
			
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
			
			handler.addObject(new Trail((int) x, (int) y, ID.Trail, 20, 20, 0.02f, Color.red, handler, true));
			
			hit();
		}

		public void render(Graphics g) {
			
			g.setColor(Color.red);
			g.fillRect((int) x, (int) y, 20, 20);
			
		}
		
		public void hit() {
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject != this) {
				
				if (tempObject.getID() == ID.Enemy || tempObject.getID() == ID.SmartEnemy) {
					
					if(getBounds().intersects(tempObject.getBounds())) {
							 handler.removeObject(this);
							 handler.removeObject(tempObject);
					}
				}
			}
		}
	}
		
		
}
