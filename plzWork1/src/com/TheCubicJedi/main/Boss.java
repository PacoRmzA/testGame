package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss extends GameObject {

		
		private Handler handler;
		private Random r;
		private int entranceTimer = 80;
		private boolean entered = false;
		public static Color bossColor = new Color(255,120,30);
		private int bulletSpawn;
		public int health = 100;
		

		public Boss(float x, float y, ID id, Handler handler, HUD hud) {
			super(x, y, id, handler, hud);
			this.handler = handler;
			velY = 2;
			r = new Random();
		}
		
		
		
		public Rectangle getBounds() {
			return new Rectangle((int) x, (int) y, 150, 150); 
		}
		
		public void tick() {
			x += velX;
			y += velY;
			
			if(entranceTimer > 0) entranceTimer--;
			else if (!entered) {
				velY = 0;
				velX = 5;
				entered = true;
			}
			
			if(x <= 0 || x >= Game.WIDTH - 150) velX *= -1;
			
			if (entered) {
				bulletSpawn = r.nextInt(10);
				if (bulletSpawn == 0) handler.addObject(new BossBullet((int)x+75, (int)y+150, ID.Bullet, handler, hud));
			}
			
			hit();
			
			if(health <= 0) {
				handler.removeObject(this);
			}

		}

		public void render(Graphics g) {
			
			g.setColor(bossColor);
			g.fillRect((int) x, (int) y, 150, 150);
			
		}
		
		public void hit() {
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject != this) {
				
				if (tempObject.getID() == ID.Enemy || tempObject.getID() == ID.SmartEnemy) {
					
					if(getBounds().intersects(tempObject.getBounds())) {
							 handler.removeObject(tempObject);
					}

				}
				
				if (tempObject.getID() == ID.Bullet) {
					
					if(getBounds().intersects(tempObject.getBounds())) {
							 handler.removeObject(tempObject);
							 health-=10;
					}

				}
				}
			}
		}
}
		
		

