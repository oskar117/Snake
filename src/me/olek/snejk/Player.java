package me.olek.snejk;

import java.awt.*;

public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}
	
	public void tick() {
		
		if(right) x+=32;
        if(left) x-=32;
        if(up) y-=32;
        if(down) y+=32;
		
		if(Snejk.borderCheck(x, y)) {
			Snejk.setKeepRunning(false);
		}
		
		//System.out.println("player: " +x+" "+y);
		//System.out.println(right + " " + left +" "+ up + " " + down);
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, y, 30, 30);
	}
}
