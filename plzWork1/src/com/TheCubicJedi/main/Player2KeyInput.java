package com.TheCubicJedi.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player2KeyInput extends KeyAdapter{
		
		private Handler handler;
		private boolean[] keyDown = new boolean[4];
		HUD hud;
		
		public static final int WIDTH = 1280, HEIGHT = WIDTH/16*9;
		
		public Player2KeyInput(Handler handler, HUD hud) {
			this.handler = handler;
			this.hud = hud;
			
			keyDown[0]=false;
			keyDown[1]=false;
			keyDown[2]=false;
			keyDown[3]=false;

		}

		public void keyPressed (KeyEvent e) {
			int key  = e.getKeyCode();
			boolean player2On = false;
			
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				
				if(tempObject.getID() == ID.Player2){
					
					if(key == KeyEvent.VK_I) {tempObject.setVelY(-10); keyDown[0] = true;}
					if(key == KeyEvent.VK_J) {tempObject.setVelX(-10); keyDown[1] = true;}
					if(key == KeyEvent.VK_K) {tempObject.setVelY(10); keyDown[2] = true;}
					if(key == KeyEvent.VK_L) {tempObject.setVelX(10); keyDown[3] = true;}
					
					player2On = true;
				}
				
			}
			
			if(!player2On) {
				if(key == KeyEvent.VK_I) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player2, handler, hud));}
				if(key == KeyEvent.VK_J) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player2, handler, hud));}
				if(key == KeyEvent.VK_K) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player2, handler, hud));}
				if(key == KeyEvent.VK_L) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player2, handler, hud));}
			}
			
		}
		
	public void keyReleased (KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
		
		if(tempObject.getID() == ID.Player2){
			
			if(key == KeyEvent.VK_I) keyDown[0]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_J) keyDown[1]=false; //tempObject.setVelX(0);
			if(key == KeyEvent.VK_K) keyDown[2]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_L) keyDown[3]=false; //tempObject.setVelX(0);
<<<<<<< HEAD
			if(key == KeyEvent.VK_U) {
				Player player = (Player) tempObject;
				player.parrying = true;
			}
=======
>>>>>>> 2bab5436040010f2118a3da3893e17bbf2f33128
			
			if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
			if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
			
		}
		
		
		}
	}
}
