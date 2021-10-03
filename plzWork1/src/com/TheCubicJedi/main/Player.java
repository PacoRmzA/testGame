package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	Color color;
	HUD hud;
	Coin coin;
<<<<<<< HEAD
	public boolean parrying;
	public int parryTimer = 5;
	
	public Player(float x, float y, ID id, Handler handler, HUD hud) {
		super(x, y, id, handler, hud);
=======
	
	public Player(float x, float y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
		this.handler = handler;
		this.hud = hud;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 32, 32); 
	}
	
	public void run(){
		x += velX;
		y += velY;
		
		
		x = Game.clamp((int) x, 0, Game.WIDTH - 38);	
		y = Game.clamp((int) y, 0, Game.HEIGHT - 66);
		
<<<<<<< HEAD
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, 32, 32, 0.1f, color, handler, false, hud));
		
		if(collision()) 
		
		handler.addCoin(new Coin((r.nextInt(Game.WIDTH - 38)), (r.nextInt(Game.HEIGHT - 66)), ID.Coin, handler, hud.getMaxLevel(), hud));
		hit();
		
		if(handler.coins.size() == 0) handler.addCoin(new Coin((r.nextInt(Game.WIDTH - 38)), (r.nextInt(Game.HEIGHT - 66)), ID.Coin, handler, hud.getMaxLevel(), hud));
=======
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, 32, 32, 0.1f, color, handler, false));
		
		if(collision()) 
		
		handler.addCoin(new Coin((r.nextInt(Game.WIDTH - 38)), (r.nextInt(Game.HEIGHT - 66)), ID.Coin, handler, hud.getMaxLevel()));
		hit();
		
		if(handler.coins.size() == 0) handler.addCoin(new Coin((r.nextInt(Game.WIDTH - 38)), (r.nextInt(Game.HEIGHT - 66)), ID.Coin, handler, hud.getMaxLevel()));
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
	}
	
	public void tick() {
		run();
<<<<<<< HEAD
		if(parrying)parryTimer--;
		if(parryTimer == 0) {
			parrying = false;
			parryTimer = 10;
		}
=======
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
	}

	public boolean collision() {
		boolean collided = false;
		for(int i = 0; i < handler.coins.size(); i++){
			
			Coin coin = handler.coins.get(i);
			
				if(getBounds().intersects(coin.getBounds())) {
					if(this.getID() == ID.Player) {
						hud.setScoreP1(hud.getScoreP1()+10*coin.getCoinLevel());
					}
					if(this.getID() == ID.Player2) {
						hud.setScoreP2(hud.getScoreP2()+10*coin.getCoinLevel());
					}
					if(this.getID() == ID.Player3) {
						hud.setScoreP3(hud.getScoreP3()+10*coin.getCoinLevel());
					}
					if(this.getID() == ID.Player4) {
						hud.setScoreP4(hud.getScoreP4()+10*coin.getCoinLevel());
					}
					collided = true;
					handler.removeCoin(coin);
			} 
			
		}
		
		return collided;
	}
	
	public void hit() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
<<<<<<< HEAD
			if ((tempObject.getID() == ID.Enemy || tempObject.getID() == ID.SmartEnemy) && !parrying) {
=======
			if (tempObject.getID() == ID.Enemy || tempObject.getID() == ID.SmartEnemy) {
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					if(this.getID() == ID.Player) {
						
						if(hud.getScoreP1() >= 10*hud.getLevelP1()) {
							hud.setScoreP1(hud.getScoreP1()-10*hud.getLevelP1());
						}
						else if (hud.getLevelP1() > 1){
							hud.setLevelP1(hud.getLevelP1() - 1);
							hud.setScoreP1(hud.getLevelP1()*200-hud.getLevelP1()*10);
							}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player2) {
						if(hud.getScoreP2() >= 10*hud.getLevelP2()) {
							hud.setScoreP2(hud.getScoreP2()-10*hud.getLevelP2());
						}
						else if (hud.getLevelP2() > 1){
							hud.setLevelP2(hud.getLevelP2() - 1);
							hud.setScoreP2(hud.getLevelP2()*200-hud.getLevelP2()*10);
							}
						else handler.removeObject(this);
					}
					
					if(this.getID() == ID.Player3) {
						if(hud.getScoreP3() >= 10*hud.getLevelP3()) {
							hud.setScoreP3(hud.getScoreP3()-10*hud.getLevelP3());
						}
						else if (hud.getLevelP3() > 1){
							hud.setLevelP3(hud.getLevelP3() - 1);
							hud.setScoreP3(hud.getLevelP3()*200-hud.getLevelP3()*10);
						}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player4) {
						if(hud.getScoreP4() >= 10*hud.getLevelP4()) {
							hud.setScoreP4(hud.getScoreP4()-10*hud.getLevelP4());
						}
						else if (hud.getLevelP4() > 1){
							hud.setLevelP4(hud.getLevelP4() - 1);
							hud.setScoreP4(hud.getLevelP4()*200-hud.getLevelP4()*10);
						}
						else handler.removeObject(this);
					}
					handler.removeObject(tempObject);
<<<<<<< HEAD
					if (tempObject.getID() == ID.Enemy)handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler, hud));
					else handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler, hud));
				}
			}
			
if (tempObject.getID() == ID.Bullet && !parrying) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					if(this.getID() == ID.Player) {
						
						if(hud.getScoreP1() >= 10*hud.getLevelP1()) {
							hud.setScoreP1(hud.getScoreP1()-10*hud.getLevelP1());
						}
						else if (hud.getLevelP1() > 1){
							hud.setLevelP1(hud.getLevelP1() - 1);
							hud.setScoreP1(hud.getLevelP1()*200-hud.getLevelP1()*10);
							}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player2) {
						if(hud.getScoreP2() >= 10*hud.getLevelP2()) {
							hud.setScoreP2(hud.getScoreP2()-10*hud.getLevelP2());
						}
						else if (hud.getLevelP2() > 1){
							hud.setLevelP2(hud.getLevelP2() - 1);
							hud.setScoreP2(hud.getLevelP2()*200-hud.getLevelP2()*10);
							}
						else handler.removeObject(this);
					}
					
					if(this.getID() == ID.Player3) {
						if(hud.getScoreP3() >= 10*hud.getLevelP3()) {
							hud.setScoreP3(hud.getScoreP3()-10*hud.getLevelP3());
						}
						else if (hud.getLevelP3() > 1){
							hud.setLevelP3(hud.getLevelP3() - 1);
							hud.setScoreP3(hud.getLevelP3()*200-hud.getLevelP3()*10);
						}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player4) {
						if(hud.getScoreP4() >= 10*hud.getLevelP4()) {
							hud.setScoreP4(hud.getScoreP4()-10*hud.getLevelP4());
						}
						else if (hud.getLevelP4() > 1){
							hud.setLevelP4(hud.getLevelP4() - 1);
							hud.setScoreP4(hud.getLevelP4()*200-hud.getLevelP4()*10);
						}
						else handler.removeObject(this);
					}
					handler.removeObject(tempObject);
				}
			}
			
			
if (tempObject.getID() == ID.Boss) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					if(this.getID() == ID.Player) {
						
						if(hud.getScoreP1() >= 10*hud.getLevelP1()) {
							hud.setScoreP1(hud.getScoreP1()-50*hud.getLevelP1());
						}
						else if (hud.getLevelP1() > 1){
							hud.setLevelP1(hud.getLevelP1() - 1);
							hud.setScoreP1(hud.getLevelP1()*200-hud.getLevelP1()*50);
							}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player2) {
						if(hud.getScoreP2() >= 10*hud.getLevelP2()) {
							hud.setScoreP2(hud.getScoreP2()-50*hud.getLevelP2());
						}
						else if (hud.getLevelP2() > 1){
							hud.setLevelP2(hud.getLevelP2() - 1);
							hud.setScoreP2(hud.getLevelP2()*200-hud.getLevelP2()*50);
							}
						else handler.removeObject(this);
					}
					
					if(this.getID() == ID.Player3) {
						if(hud.getScoreP3() >= 10*hud.getLevelP3()) {
							hud.setScoreP3(hud.getScoreP3()-50*hud.getLevelP3());
						}
						else if (hud.getLevelP3() > 1){
							hud.setLevelP3(hud.getLevelP3() - 1);
							hud.setScoreP3(hud.getLevelP3()*200-hud.getLevelP3()*50);
						}
						else handler.removeObject(this);
					}
					if(this.getID() == ID.Player4) {
						if(hud.getScoreP4() >= 10*hud.getLevelP4()) {
							hud.setScoreP4(hud.getScoreP4()-50*hud.getLevelP4());
						}
						else if (hud.getLevelP4() > 1){
							hud.setLevelP4(hud.getLevelP4() - 1);
							hud.setScoreP4(hud.getLevelP4()*200-hud.getLevelP4()*50);
						}
						else handler.removeObject(this);
					}
				}
			}
			
if ((tempObject.getID() == ID.Bullet || tempObject.getID() == ID.Enemy) && parrying) {
	
	System.out.println("parrying" + this.id);
	if(getBounds().intersects(tempObject.getBounds())) {
		tempObject.velX *= -1;
		tempObject.velY *= -1;
	}
}
=======
					if (tempObject.getID() == ID.Enemy )handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler));
					else handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler));
				}
			}
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
		}
	}
	
	public void render(Graphics g) {
		if(id == ID.Player) {
			g.setColor(Color.white);
			color = Color.white;
		} else if (id == ID.Player2) {
			g.setColor(Color.cyan);
			color = Color.cyan;
		}
		else if (id == ID.Player3) {
			g.setColor(Color.green);
			color = Color.green;
		}
		else if (id == ID.Player4) {
			g.setColor(Color.yellow);
			color = Color.yellow;
		}
		g.fillRect((int) x, (int) y, 32, 32);
	}
<<<<<<< HEAD
	
=======

>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
}
