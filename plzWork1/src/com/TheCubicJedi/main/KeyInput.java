package com.TheCubicJedi.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	HUD hud;
	
	public KeyInput(HUD hud) {
		this.hud = hud;
		
	}

	public void keyPressed (KeyEvent e) {
		int key  = e.getKeyCode();
		
		if(key == KeyEvent.VK_Z) hud.setScoreP1(hud.getScoreP1()+100);
		if(key == KeyEvent.VK_X) hud.setScoreP2(hud.getScoreP2()+100);
		if(key == KeyEvent.VK_C) hud.setScoreP3(hud.getScoreP3()+100);
		if(key == KeyEvent.VK_V) hud.setScoreP4(hud.getScoreP4()+100);

		
	}
	
public void keyReleased (KeyEvent e) {
	int key  = e.getKeyCode();
	
	if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	
	}
	
	
}
