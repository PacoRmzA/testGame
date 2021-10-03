package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.TheCubicJedi.main.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r;
	private HUD hud;
	
	public Menu (Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed (MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//play button
		if(mouseOver(mx, my, 490, 175, 300, 100) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Game;
			handler.addCoin(new Coin(r.nextInt(Game.WIDTH-10), r.nextInt(Game.HEIGHT-10), ID.Coin, handler, 1, hud));
		}
		
		//help button
		if(mouseOver(mx, my, 490, 325, 300, 100) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Help;
		}
		
		//quit button
		if(mouseOver(mx, my, 490, 475, 300, 100) && game.gameState == STATE.Menu) System.exit(1);
		
		//back to menu from help
		if(game.gameState == STATE.Help && mouseOver(mx, my, 965, 550, 150, 75)) {
			game.gameState = STATE.Menu;
		}
	}
	
	public void mouseReleased (MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick () { 
		
	}
	
	public void render (Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1, 70);
		Font fnt2 = new Font("arial", 1, 40);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 550, 100);
		g.setFont(fnt2);
		g.drawString("Play", 595, 240);
		g.drawString("Help", 595, 390);
		g.drawString("Quit", 595, 540);
		
		g.drawRect(490, 175, 300, 100);
		g.drawRect(490, 325, 300, 100);
		g.drawRect(490, 475, 300, 100);
		} else if (game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 70);
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 550, 100);
			g.setFont(fnt2);
			g.drawString("Collect coins, avoid enemies and parry bullets!", 200, 240);
			g.drawString("Player 1 moves with WASD and parries with Q", 200, 290);
			g.setColor(Color.cyan);
			g.drawString("Player 2 moves with IJKL and parries with U", 200, 340);
			g.setColor(Color.green);
			g.drawString("Player 3 moves with the ARROW KEYS and parries with SPACE", 200, 390);
			g.setColor(Color.yellow);
			g.drawString("Player 4 moves with TFGH and parries with R", 200, 440);
			g.setColor(Color.white);
			g.drawString("To spawn, just move!", 200, 490);
			g.drawString("Back", 1000, 600);
			g.drawRect(965, 550, 150, 75);
			
		}
	}
	
}
