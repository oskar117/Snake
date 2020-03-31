package me.olek.snejk;

import java.awt.Color;
import java.awt.Graphics;

public class Fruit extends GameObject{

	public Fruit(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 30, 30);
	}
}
