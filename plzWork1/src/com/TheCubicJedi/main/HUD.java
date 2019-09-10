package com.TheCubicJedi.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;;

public class HUD {

	private static int SCOREp1 = 0;
	private static int SCOREp2 = 0;
	private static int SCOREp3 = 0;
	private static int SCOREp4 = 0;
	
	private int levelP1 = 1;
	private int levelP2 = 1;
	private int levelP3 = 1;
	private int levelP4 = 1;
	
	private int greenValue1 = 255;
	private int greenValue2 = 255;
	private int greenValue3 = 255;
	private int greenValue4 = 255;
	
	
	public void tick(){
		SCOREp1 = Game.clamp(SCOREp1, 0, getLevelP1()*200);
		SCOREp2 = Game.clamp(SCOREp2, 0, getLevelP2()*200);
		SCOREp3 = Game.clamp(SCOREp3, 0, getLevelP3()*200);
		SCOREp4 = Game.clamp(SCOREp4, 0, getLevelP4()*200);
		
		greenValue1 = Game.clamp(greenValue1, 0, 255);
		greenValue2 = Game.clamp(greenValue2, 0, 255);
		greenValue3 = Game.clamp(greenValue3, 0, 255);
		greenValue4 = Game.clamp(greenValue4, 0, 255);
		
		greenValue1 = SCOREp1;
		greenValue2 = SCOREp2;
		greenValue3 = SCOREp3;
		greenValue4 = SCOREp4;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue1/getLevelP1(), 0));
		g.fillRect(15, 15, SCOREp1/getLevelP1(), 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.gray);
		g.fillRect(225, 15, 200, 32);
		g.setColor(new Color(75, greenValue2/getLevelP2(), 0));
		g.fillRect(225, 15, SCOREp2/getLevelP2(), 32);
		g.setColor(Color.cyan);
		g.drawRect(225, 15, 200, 32);
		
		g.setColor(Color.gray);
		g.fillRect(435, 15, 200, 32);
		g.setColor(new Color(75, greenValue3/getLevelP3(), 0));
		g.fillRect(435, 15, SCOREp3/getLevelP3(), 32);
		g.setColor(Color.green);
		g.drawRect(435, 15, 200, 32);
		
		g.setColor(Color.gray);
		g.fillRect(645, 15, 200, 32);
		g.setColor(new Color(75, greenValue4/getLevelP4(), 0));
		g.fillRect(645, 15, SCOREp4/getLevelP4(), 32);
		g.setColor(Color.yellow);
		g.drawRect(645, 15, 200, 32);
		
		g.setColor(Color.white);
		
		g.drawString("P1 Score: " + SCOREp1, 15, 64);
		g.drawString("P2 Score: " + SCOREp2, 225, 64);
		g.drawString("P3 Score: " + SCOREp3, 435, 64);
		g.drawString("P4 Score: " + SCOREp4, 645, 64);
		
		g.drawString("P1 Level: " + levelP1, 15, 80);
		g.drawString("P2 Level: " + levelP2, 225, 80);
		g.drawString("P3 Level: " + levelP3, 435, 80);
		g.drawString("P4 Level: " + levelP4, 645, 80);
		
		
	}
	
	public int getScoreP1() {
		return SCOREp1;
	}
	
	public int getScoreP2() {
		return SCOREp2;
	}
	
	public int getScoreP3() {
		return SCOREp3;
	}
	
	public int getScoreP4() {
		return SCOREp4;
	}
	
	public void setScoreP1(int SCOREp1) {
		HUD.SCOREp1 = SCOREp1;
	}
	
	public void setScoreP2(int SCOREp2) {
		HUD.SCOREp2 = SCOREp2;
	}
	
	public void setScoreP3(int SCOREp3) {
		HUD.SCOREp3 = SCOREp3;
	}
	
	public void setScoreP4(int SCOREp4) {
		HUD.SCOREp4 = SCOREp4;
	}
	
	public int getLevelP1() {
		return levelP1;
	}
	
	public int getLevelP2() {
		return levelP2;
	}
	
	public int getLevelP3() {
		return levelP3;
	}
	
	public int getLevelP4() {
		return levelP4;
	}
	
	public int getMaxLevel() {
		ArrayList<Integer> levels = new ArrayList<Integer>();
		levels.add(levelP1);
		levels.add(levelP2);
		levels.add(levelP3);
		levels.add(levelP4);
		
		Collections.sort(levels);
		return levels.get(3);
	}
	
	public void setLevelP1(int levelP1) {
		this.levelP1 = levelP1;
	}
	
	public void setLevelP2(int levelP2) {
		this.levelP2 = levelP2;
	}
	
	public void setLevelP3(int levelP3) {
		this.levelP3 = levelP3;
	}
	
	public void setLevelP4(int levelP4) {
		this.levelP4 = levelP4;
	}
	
}
