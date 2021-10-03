package com.TheCubicJedi.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player1KeyInput extends KeyAdapter {
		
		private Handler handler;
		private boolean[] keyDown = new boolean[4];
		HUD hud;
		
		public static final int WIDTH = 1280, HEIGHT = WIDTH/16*9;
		
		public Player1KeyInput(Handler handler, HUD hud) {
			this.handler = handler;
			this.hud = hud;
			
			keyDown[0]=false;
			keyDown[1]=false;
			keyDown[2]=false;
			keyDown[3]=false;

		}

		public void keyPressed (KeyEvent e) {
			int key  = e.getKeyCode();
			boolean player1On = false;
			
			for(int i = 0; i < handler.object.size(); i++) {
				
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.Player){
				
					if(key == KeyEvent.VK_W) {tempObject.setVelY(-10); keyDown[0] = true;}
					if(key == KeyEvent.VK_A) {tempObject.setVelX(-10); keyDown[1] = true;}
					if(key == KeyEvent.VK_S) {tempObject.setVelY(10); keyDown[2] = true;}
					if(key == KeyEvent.VK_D) {tempObject.setVelX(10); keyDown[3] = true;}
					player1On = true;
				}
				
				
			}
			
			if(!player1On) {
				if(key == KeyEvent.VK_W) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler, hud));}
				if(key == KeyEvent.VK_A) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler, hud));}
				if(key == KeyEvent.VK_S) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler, hud));}
				if(key == KeyEvent.VK_D) {handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler, hud));}
			}
			
		}
		
	public void keyReleased (KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
		if(tempObject.getID() == ID.Player){
			
			if(key == KeyEvent.VK_W) keyDown[0]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_A) keyDown[1]=false; //tempObject.setVelX(0);
			if(key == KeyEvent.VK_S) keyDown[2]=false; //tempObject.setVelY(0);
			if(key == KeyEvent.VK_D) keyDown[3]=false; //tempObject.setVelX(0);
<<<<<<< HEAD
			if(key == KeyEvent.VK_Q) {
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

