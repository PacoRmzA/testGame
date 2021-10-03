package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject {

		
		private Handler handler;
		public static Color bulletColor = new Color(255, 220, 120);
		

		public BossBullet(float x, float y, ID id, Handler handler, HUD hud) {
			super(x, y, id, handler, hud);
			
			this.handler = handler;
			
			Random r = new Random();
			velX = r.nextInt(10)-5;
			velY = r.nextInt(9)+1;
		}

		public Rectangle getBounds() {
			return new Rectangle((int) x, (int) y, 10, 10); 
		}
		
		public void tick() {
			x += velX;
			y += velY;
			
			if(y <= 0 || y >= Game.HEIGHT - 64) handler.removeObject(this);
			if(x <= 0 || x >= Game.WIDTH - 20) handler.removeObject(this);
			
			handler.addObject(new Trail((int) x, (int) y, ID.Trail, 10, 10, 0.02f, bulletColor, handler, false, hud));
			
			hit();
		}

		public void render(Graphics g) {
			
			g.setColor(bulletColor);
			g.fillRect((int) x, (int) y, 10, 10);
			
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
