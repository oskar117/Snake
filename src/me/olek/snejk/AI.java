package me.olek.snejk;

public class AI {

	private Handler handler;
	private Player player;
	private int targetX = 0;
	private int targetY = 0;
	private boolean wasHere[][] = new boolean[Snejk.WIDTH*Snejk.SCALE][Snejk.HEIGHT*Snejk.SCALE];
	
	public AI(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		
		for(int x = 0; x<Snejk.WIDTH*Snejk.SCALE; x++) {
			for(int y = 0; y<Snejk.HEIGHT*Snejk.SCALE; y++) {
				wasHere[x][y] = false;
			}
		}
	}
	
	public void tick() {
		int playerX = player.getX();
		int playerY = player.getY();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp instanceof Fruit) {
				targetX = temp.getX();
				targetY = temp.getY();
			}
		}	
		
		/*if(playerX == targetX) {
			if(playerY < targetY) {
				if(isCordAvible(playerX, playerY+32)) player.setDown();
				else if(isCordAvible(playerX-32, playerY)) player.setLeft();
				else if(isCordAvible(playerX+32, playerY)) player.setRight();
				else if(isCordAvible(playerX, playerY-32)) player.setUp();
			} else if(playerY > targetY) {
				if(isCordAvible(playerX, playerY-32)) player.setUp();
				else if(isCordAvible(playerX-32, playerY)) player.setLeft();
				else if(isCordAvible(playerX+32, playerY)) player.setRight();
				else if(isCordAvible(playerX, playerY+32)) player.setDown();
			}				
		} else if(playerY == targetY) {
			if(playerX < targetX) {
				if(isCordAvible(playerX+32, playerY)) player.setRight();
				else if(isCordAvible(playerX, playerY-32)) player.setUp();
				else if(isCordAvible(playerX, playerY+32)) player.setDown();
				else if(isCordAvible(playerX-32, playerY)) player.setLeft();
			} else if(playerX > targetX) {
				if(isCordAvible(playerX-32, playerY)) player.setLeft();
				else if(isCordAvible(playerX, playerY-32)) player.setUp();
				else if(isCordAvible(playerX, playerY+32)) player.setDown();
				else if(isCordAvible(playerX+32, playerY)) player.setRight();
			}
		} else {
			if(player.isLeft()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isCordAvible(playerX, playerY+32)) player.setDown();
						else {
							if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
						}
					}else {
						if(isCordAvible(playerX, playerY-32)) player.setUp();
						else {
							if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
						}
					}
				} else {
					if (playerY < targetY) {
						if(isCordAvible(playerX-32, playerY)) player.setLeft();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
						}
					} else {
						if(isCordAvible(playerX-32, playerY)) player.setLeft();
						else {
							if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
						}
					}
				}
			}
			
			if(player.isRight()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isCordAvible(playerX+32, playerY)) player.setRight();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
						}
					}else {
						if(isCordAvible(playerX+32, playerY)) player.setRight();
						else {
							if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
						}
					}
				} else {
					if (playerY < targetY) {
						if(isCordAvible(playerX, playerY+32)) player.setDown();
						else {
							if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
						}
					} else {
						if(isCordAvible(playerX, playerY-32)) player.setUp();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
							
						}
					}
				}
			}
			
			if(player.isUp()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isCordAvible(playerX+32, playerY)) player.setRight();
						else {
							if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
						}
					}else {
						if(isCordAvible(playerX, playerY-32)) player.setUp();
						else {
							if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
							
						}
					}
				} else {
					if (playerY < targetY) {
						if(isCordAvible(playerX-32, playerY)) player.setLeft();
						else {
							if(isCordAvible(playerX, playerY-32)) player.setUp();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
						}
					} else {
						if(isCordAvible(playerX, playerY-32)) player.setUp();
						else {
							if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX, playerY+32)) player.setDown();
							
						}
					}
				}
			}
			
			if(player.isDown()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isCordAvible(playerX, playerY+32)) player.setDown();
						else {
							if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
						}
					}else {
						if(isCordAvible(playerX+32, playerY)) player.setRight();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX-32, playerY)) player.setLeft();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();			
						}
					}
				} else {
					if (playerY < targetY) {
						if(isCordAvible(playerX-32, playerY)) player.setLeft();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
						}
					} else {
						if(isCordAvible(playerX-32, playerY)) player.setLeft();
						else {
							if(isCordAvible(playerX, playerY+32)) player.setDown();
							else if(isCordAvible(playerX+32, playerY)) player.setRight();
							else if(isCordAvible(playerX, playerY-32)) player.setUp();
						}
					}
				}
			}
		}*/
		
		if(playerX == targetX) {
			if(playerY < targetY) {
				if(isPathAvible(2, playerX, playerY+32)) player.setDown();
				else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
				else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
				else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
				else {
					if(isCordAvible(playerX, playerY+32)) player.setDown();
					else if(isCordAvible(playerX-32, playerY)) player.setLeft();
					else if(isCordAvible(playerX+32, playerY)) player.setRight();
					else if(isCordAvible(playerX, playerY-32)) player.setUp();
					else System.out.println("nie ma dzie jechac");
				}
			} else if(playerY > targetY) {
				if(isPathAvible(0, playerX, playerY-32)) player.setUp();
				else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
				else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
				else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
				else {
					if(isCordAvible(playerX, playerY-32)) player.setUp();
					else if(isCordAvible(playerX-32, playerY)) player.setLeft();
					else if(isCordAvible(playerX+32, playerY)) player.setRight();
					else if(isCordAvible(playerX, playerY+32)) player.setDown();
					else System.out.println("nie ma dzie jechac");
				}
			}				
		} else if(playerY == targetY) {
			if(playerX < targetX) {
				if(isPathAvible(1, playerX+32, playerY)) player.setRight();
				else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
				else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
				else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
				else {
					if(isCordAvible(playerX+32, playerY)) player.setRight();
					else if(isCordAvible(playerX, playerY-32)) player.setUp();
					else if(isCordAvible(playerX, playerY+32)) player.setDown();
					else if(isCordAvible(playerX-32, playerY)) player.setLeft();
					else System.out.println("nie ma dzie jechac");
				}
			} else if(playerX > targetX) {
				if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
				else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
				else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
				else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
				else {
					if(isCordAvible(playerX-32, playerY)) player.setLeft();
					else if(isCordAvible(playerX, playerY-32)) player.setUp();
					else if(isCordAvible(playerX, playerY+32)) player.setDown();
					else if(isCordAvible(playerX+32, playerY)) player.setRight();		
					else System.out.println("nie ma dzie jechac");
				}
			}
		} else {
			if(player.isLeft()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isPathAvible(2, playerX, playerY+32)) player.setDown();
						else {
							if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else {
								if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}else {
						if(isPathAvible(0, playerX, playerY-32)) player.setUp();
						else {
							if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else {
								if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				} else {
					if (playerY < targetY) {
						if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
						else {
							if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else {
								if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else System.out.println("nie ma dzie jechac");
							}
						}
					} else {
						if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
						else {
							if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else {
								if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				}
			}
			
			else if(player.isRight()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isPathAvible(1, playerX+32, playerY)) player.setRight();
						else {
							if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}else {
						if(isPathAvible(1, playerX+32, playerY)) player.setRight();
						else {
							if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				} else {
					if (playerY < targetY) {
						if(isPathAvible(2, playerX, playerY+32)) player.setDown();
						else {
							if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else System.out.println("nie ma dzie jechac");
							}
						}
					} else {
						if(isPathAvible(0, playerX, playerY-32)) player.setUp();
						else {
							if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else if(isPathAvible(1, playerX+32, playerY)) player.setRight();		
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				}
			}
			
			else if(player.isUp()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isPathAvible(1, playerX+32, playerY)) player.setRight();
						else {
							if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}else {
						if(isPathAvible(0, playerX, playerY-32)) player.setUp();
						else {
							if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				} else {
					if (playerY < targetY) {
						if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
						else {
							if(isPathAvible(0, playerX, playerY-32)) player.setUp();
							else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					} else {
						if(isPathAvible(0, playerX, playerY-32)) player.setUp();
						else {
							if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else {
								if(isCordAvible(playerX, playerY-32)) player.setUp();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				}
			}
			
			else if(player.isDown()) {
				if(playerX < targetX) {
					if (playerY < targetY) {
						if(isPathAvible(2, playerX, playerY+32)) player.setDown();
						else {
							if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else {
								if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}else {
						if(isPathAvible(1, playerX+32, playerY)) player.setRight();
						else {
							if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else {
								if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				} else {
					if (playerY < targetY) {
						if(isPathAvible(2, playerX, playerY+32)) player.setDown();	
						else {
							if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
							else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else {
								if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					} else {
						if(isPathAvible(3, playerX-32, playerY)) player.setLeft();
						else {
							if(isPathAvible(2, playerX, playerY+32)) player.setDown();
							else if(isPathAvible(1, playerX+32, playerY)) player.setRight();
							else {
								if(isCordAvible(playerX, playerY+32)) player.setDown();
								else if(isCordAvible(playerX+32, playerY)) player.setRight();
								else if(isCordAvible(playerX-32, playerY)) player.setLeft();
								else System.out.println("nie ma dzie jechac");
							}
						}
					}
				}
			}
		}
	}
	
	private boolean isPathAvible(int dir, int x, int y) {
		if(x == targetX && y == targetY) {
			for(int xx = 0; xx<Snejk.WIDTH*Snejk.SCALE; xx++) {
				for(int yy = 0; yy<Snejk.HEIGHT*Snejk.SCALE; yy++) {
					wasHere[xx][yy] = false;
				}
			}
			return true;
		}
		if(!isCordAvible(x, y) || wasHere[x][y] == true) return false;
		wasHere[x][y] = true;
		if(dir == 3) {
			if(x < targetX) {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				} else {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;	
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				}
			} else if(x > targetX){
				if (y < targetY) {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				} else {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else return false;
					}
				}
			} else {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;	
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;			
						else return false;			
					}
				} else {
					System.out.println("wiadomix1");
				}
			}
		}
		if(dir == 1) {
			if(x < targetX) {
				if (y < targetY) {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
					}
				} else {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
					}
				}
			} else if(x > targetX){
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;	
						else if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
						
					}
				} else {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;	
						else if(isPathAvible(3, x-32, y)) return true;		
						else return false;	
					}
				}
			} else {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;	
						else if(isPathAvible(0, x, y-32)) return true;	
						else if(isPathAvible(3, x-32, y)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;	
						else if(isPathAvible(3, x-32, y)) return true;									
						else return false;		
					}
				} else {
					System.out.println("wiadomix2");
				}
			}
		}
		if(dir == 0) {
			if(x < targetX) {
				if (y < targetY) {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {					
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;
					}
				} else {
					if(isPathAvible(1, x+32, y)) return true;
					else {					
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;
					}
				}
			} else if(x > targetX){
				if (y < targetY) {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;			
					}
				} else {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(0, x, y-32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(2, x, y+32)) return true;
						else return false;
					}
				}
			} else {
				if (y < targetY) {
					if(isPathAvible(1, x+32, y)) return true;					
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;		
						else if(isPathAvible(2, x, y+32)) return true;										
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(0, x, y-32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;	
						else if(isPathAvible(2, x, y+32)) return true;												
						else return false;			
					}
				} else {
					System.out.println("wiadomix3");
				}
			}
		}
		if(dir == 2) {
			if(x < targetX) {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;		
					}
				} else {
					if(isPathAvible(1, x+32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;
					}
				}
			} else if(x > targetX) {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;
					else {
						if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;
					}
				} else if(y > targetY) {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;
					}
				} else {
					if(isPathAvible(3, x-32, y)) return true;
					else {
						if(isPathAvible(2, x, y+32)) return true;
						else if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;
						else return false;
					}
				}
			} else {
				if (y < targetY) {
					if(isPathAvible(2, x, y+32)) return true;						
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;														
						else return false;		
					}				
				} else if(y > targetY) {
					if(isPathAvible(2, x, y+32)) return true;						
					else {
						if(isPathAvible(1, x+32, y)) return true;
						else if(isPathAvible(3, x-32, y)) return true;
						else if(isPathAvible(0, x, y-32)) return true;														
						else return false;
					}
				} else {
					System.out.println("wiadomix4");
				}
			}
		}
		return false;
	}
		
	private boolean isCordAvible(int x, int y) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(!(temp instanceof Fruit)) {
				if(x == temp.getX() && y == temp.getY()) {
					//System.out.println("nie jest git: " + x +" "+y);
					return false;
				}
				else if(Snejk.borderCheck(x, y)) return false;
			}
		}
		//System.out.println("git: " + x +" "+y);
		return true;
	}
	
}
