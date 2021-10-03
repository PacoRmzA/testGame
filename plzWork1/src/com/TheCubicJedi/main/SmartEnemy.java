
	package com.TheCubicJedi.main;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.util.Random;

	public class SmartEnemy extends GameObject {

			
			private Handler handler;
			private GameObject player;
			private Random r;
			

			public SmartEnemy(float x, float y, ID id, Handler handler, HUD hud) {
				super(x, y, id, handler, hud);
				
				r = new Random();
				
				this.handler = handler;
				
				switch (r.nextInt(4)) {
				case 1:
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
					}
				case 2:
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getID() == ID.Player2) player = handler.object.get(i);
					}
				case 3:
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getID() == ID.Player3) player = handler.object.get(i);
					}
				case 4:
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getID() == ID.Player4) player = handler.object.get(i);
					}
				}
				
			}

			public Rectangle getBounds() {
				return new Rectangle((int) x, (int) y, 16, 16); 
			}
			
			public void tick() {
				x += velX;
				y += velY;
				
				if(targetAlive()) {
				float diffX = x - player.getX() - 8;
				float diffY = y - player.getY() - 8;
				float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY())*(y-player.getY()) );
				
				velX = (float) ((-1.0/distance) * diffX * 5);
				velY = (float) ((-1.0/distance) * diffY * 5);
				
				//if(y <= 0 || y >= Game.HEIGHT - 64) velY*= -1;
				//if(x <= 0 || x >= Game.WIDTH - 20) velX*= -1;
				
				} else {
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i) != player) {
							player = handler.object.get(i);
							break;
						}
					}
				}
				
				handler.addObject(new Trail((int) x, (int) y, ID.Trail, 20, 20, 0.02f, Color.pink, handler, false, hud));
				
				hit();
			}

			public void render(Graphics g) {
				
				g.setColor(Color.pink);
				g.fillRect((int) x, (int) y, 20, 20);
				
			}
			
			public boolean targetAlive() {
				boolean isAlive = false;
				for(int i = 0; i < handler.object.size(); i++) {
					if(handler.object.get(i) == player) {
						isAlive = true;
					}
					
				}
				return isAlive;
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


