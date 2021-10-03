package com.TheCubicJedi.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player3KeyInput extends KeyAdapter {
		
		private Handler handler;
		private boolean[] keyDown = new boolean[4];
		HUD hud;
		
		public static final int WIDTH = 1280, HEIGHT = WIDTH/16*9;
		
		public Player3KeyInput(Handler handler, HUD hud) {
			this.handler = handler;
			this.hud = hud;
			
			keyDown[0]=false;
			keyDown[1]=false;
			keyDown[2]=false;
			keyDown[3]=false;
			
		}

		public void keyPressed (KeyEvent e) {
			int key  = e.getKeyCode();
			boolean player3On = false;
			
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.Player3){
					
					if(key == KeyEvent.VK_UP) {tempObject.setVelY(-10); keyDown[0] = true;}
					if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-10); keyDown[1] = true;}
					if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(10); keyDown[2] = true;}
					if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(10); keyDown[3] = true;}
					player3On = true;
				}
		
				
			}
			
			if(!player3On) {
				if(key == KeyEvent.VK_UP) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player3, handler, hud));}
				if(key == KeyEvent.VK_LEFT) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player3, handler, hud));}
				if(key == KeyEvent.VK_DOWN) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player3, handler, hud));}
				if(key == KeyEvent.VK_RIGHT) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player3, handler, hud));}
			}
			
		}
		
	public void keyReleased (KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
		
		if(tempObject.getID() == ID.Player3){
			
			if(key == KeyEvent.VK_UP) keyDown[0]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_LEFT) keyDown[1]=false; //tempObject.setVelX(0);
			if(key == KeyEvent.VK_DOWN) keyDown[2]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_RIGHT) keyDown[3]=false; //tempObject.setVelX(0);
			if(key == KeyEvent.VK_SPACE) {
				Player player = (Player) tempObject;
				player.parrying = true;
			}
			
			
			if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
			if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
			
		}
		
		
		}
}
}