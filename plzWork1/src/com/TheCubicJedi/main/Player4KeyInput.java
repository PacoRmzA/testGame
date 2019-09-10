package com.TheCubicJedi.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player4KeyInput extends KeyAdapter {
		
		private Handler handler;
		private boolean[] keyDown = new boolean[4];
		HUD hud;
		
		public static final int WIDTH = 1280, HEIGHT = WIDTH/16*9;
		
		public Player4KeyInput(Handler handler, HUD hud) {
			this.handler = handler;
			this.hud = hud;
			
			keyDown[0]=false;
			keyDown[1]=false;
			keyDown[2]=false;
			keyDown[3]=false;
			
		}

		public void keyPressed (KeyEvent e) {
			int key  = e.getKeyCode();
			boolean player4On = false;
			
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.Player4){
					
					if(key == KeyEvent.VK_T) {tempObject.setVelY(-10); keyDown[0] = true;}
					if(key == KeyEvent.VK_F) {tempObject.setVelX(-10); keyDown[1] = true;}
					if(key == KeyEvent.VK_G) {tempObject.setVelY(10); keyDown[2] = true;}
					if(key == KeyEvent.VK_H) {tempObject.setVelX(10); keyDown[3] = true;}
					player4On = true;
				}
		
				
			}
			
			if(!player4On) {
				if(key == KeyEvent.VK_T) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player4, handler, hud));}
				if(key == KeyEvent.VK_F) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player4, handler, hud));}
				if(key == KeyEvent.VK_G) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player4, handler, hud));}
				if(key == KeyEvent.VK_H) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player4, handler, hud));}
			}
			
		}
		
	public void keyReleased (KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
		
		if(tempObject.getID() == ID.Player4){
			
			if(key == KeyEvent.VK_T) keyDown[0]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_F) keyDown[1]=false; //tempObject.setVelX(0);
			if(key == KeyEvent.VK_G) keyDown[2]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_H) keyDown[3]=false; //tempObject.setVelX(0);
			
			if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
			if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
			
		}
		
		
		}
}
}