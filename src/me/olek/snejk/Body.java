package me.olek.snejk;

import java.awt.Color;
import java.awt.Graphics;

public class Body extends GameObject{
	
	public Body(int x, int y, ID id) {
		super(x, y, id);
	}
	
	@Override
	public void tick() {
		if(right) x+=32;
        if(left) x-=32;
        if(up) y-=32;
        if(down) y+=32;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 30, 30);
	}
}
