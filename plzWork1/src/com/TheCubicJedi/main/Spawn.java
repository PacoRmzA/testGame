package com.TheCubicJedi.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		r = new Random();
	}
	
	public void tick() {
		
		if(hud.getScoreP1() >= hud.getLevelP1()*200) {
			hud.setScoreP1(0);
			hud.setLevelP1(hud.getLevelP1() + 1);
			handler.coins.get(0).setCoinLevel(handler.coins.get(0).getCoinLevel()+1);
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler));
			if(hud.getMaxLevel() >= 3) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler));
		}
		
		if(hud.getScoreP2() >= hud.getLevelP2()*200) {
			hud.setScoreP2(0);
			hud.setLevelP2(hud.getLevelP2() + 1);
			handler.coins.get(0).setCoinLevel(handler.coins.get(0).getCoinLevel()+1);
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler));
			if(hud.getMaxLevel() >= 3) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler));
		}
		
		if(hud.getScoreP3() >= hud.getLevelP3()*200) {
			hud.setScoreP3(0);
			hud.setLevelP3(hud.getLevelP3() + 1);
			handler.coins.get(0).setCoinLevel(handler.coins.get(0).getCoinLevel()+1);
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler));
			if(hud.getMaxLevel() >= 3) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler));
		}
		
		if(hud.getScoreP4() >= hud.getLevelP4()*200) {
			hud.setScoreP4(0);
			hud.setLevelP4(hud.getLevelP4() + 1);
			handler.coins.get(0).setCoinLevel(handler.coins.get(0).getCoinLevel()+1);
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Enemy, handler));
			if(hud.getMaxLevel() >= 3) handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.SmartEnemy, handler));
		}
		
		}
	}


