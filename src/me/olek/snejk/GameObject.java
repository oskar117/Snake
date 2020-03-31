package me.olek.snejk;

import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected boolean right = true;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean down= false;

	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public boolean isRight() {
		return right;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}
	
	public void setLeft() {
		this.left = true;
		this.right = false;
		this.down = false;
		this.up = false;
	}
	
	
	
	public void setRight() {
		this.left = false;
		this.right = true;
		this.down = false;
		this.up = false;
	}
	
	public void setUp() {
		this.left = false;
		this.right = false;
		this.down = false;
		this.up = true;
	}
	
	public void setDown() {
		this.left = false;
		this.right = false;
		this.down = true;
		this.up = false;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
