package me.olek.snejk;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private Random random = new Random();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject temp = object.get(i);	
			if(!(temp instanceof Player)) {
				if(temp.getId() == ID.Fruit) {
					if(temp.getX() == object.get(0).x && temp.getY() == object.get(0).y) {
						
						removeObject(temp);
						
						if(object.getLast().right) {
							addObject(new Body(object.getLast().x-32, object.getLast().y, ID.Body));
							object.getLast().setRight();
						}
				        if(object.getLast().left) {
				        	addObject(new Body(object.getLast().x+32, object.getLast().y, ID.Body));
				        	object.getLast().setLeft();
				        }
				        	
				        if(object.getLast().up) {
				        	addObject(new Body(object.getLast().x, object.getLast().y+32, ID.Body));
				        	object.getLast().setUp();
				        }
				        	
				        if(object.getLast().down) {
				        	addObject(new Body(object.getLast().x, object.getLast().y-32, ID.Body));
				        	object.getLast().setDown();
				        }
				        	
				        
				        int tempFruitX;
						int tempFruitY;
						
			        	boolean collides = false;
			        	
				        do {
				        	collides = false;
				        	tempFruitX = random.nextInt(Snejk.WIDTH * Snejk.SCALE);
				        	tempFruitY = random.nextInt(Snejk.HEIGHT * Snejk.SCALE);
				        	
				        	for(GameObject ob : object) {
				        		
				        		if(tempFruitX == ob.x && tempFruitY == ob.y) {
				        			collides = true;
				        			break;
				        		}
				        	}
				        	
				        	
				        } while(tempFruitX % 32 != 4 || tempFruitY % 32 != 4 || collides);
				        
				        addObject(new Fruit(tempFruitX, tempFruitY, ID.Fruit));
					}
				}
				if(temp instanceof Body) {
					
					if(temp.getX() == object.get(0).x && temp.getY() == object.get(0).y) {
						System.out.println("Sam w siebie wjecha³");
						Snejk.setKeepRunning(false);
					}
					
					if(temp.left == true && object.get(i-1).right == true || temp.right == true && object.get(i-1).left == true) {
						if(temp.y < object.get(i-1).y) temp.setDown();
						else temp.setUp();
					}
					if(temp.up == true && object.get(i-1).down == true || temp.down == true && object.get(i-1).up == true) {
						if(temp.x > object.get(i-1).x) temp.setLeft();
						else temp.setRight();
					}
					if(temp.left == true && object.get(i-1).left == true || temp.right == true && object.get(i-1).right == true) {
						if(temp.y < object.get(i-1).y) temp.setDown();
						else temp.setUp();
					}
					if(temp.up == true && object.get(i-1).up == true || temp.down == true && object.get(i-1).down == true) {
						if(temp.x > object.get(i-1).x) temp.setLeft();
						else temp.setRight();
					}
					if(temp.left == false && object.get(i-1).left == true && (temp.y+32 != object.get(i-1).y && temp.y-32 != object.get(i-1).y)) temp.setLeft();
					if(temp.right == false && object.get(i-1).right == true && (temp.y+32 != object.get(i-1).y && temp.y-32 != object.get(i-1).y)) temp.setRight();
					if(temp.up == false && object.get(i-1).up == true && (temp.x+32 != object.get(i-1).x && temp.x-32 != object.get(i-1).x)) temp.setUp();
					if(temp.down == false && object.get(i-1).down == true && (temp.x+32 != object.get(i-1).x && temp.x-32 != object.get(i-1).x)) temp.setDown();
				}
			}
			temp.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject temp = object.get(i);
			temp.render(g);
		}
	}
	
	public void addObject(GameObject obj) {
		this.object.add(obj);
	}
	
	public void removeObject(GameObject obj) {
		this.object.remove(obj);
	}
	
	
}
