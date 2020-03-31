package me.olek.snejk;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_F1) {
			if(Snejk.isAi() == true) Snejk.setAi(false);
			else Snejk.setAi(true);
		}
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP && !temp.isDown()) temp.setUp();
				if(key == KeyEvent.VK_DOWN && !temp.isUp()) temp.setDown();
				if(key == KeyEvent.VK_LEFT && !temp.isRight()) temp.setLeft();
				if(key == KeyEvent.VK_RIGHT && !temp.isLeft()) temp.setRight();
			}
		}
	}
}
