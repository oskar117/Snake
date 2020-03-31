package me.olek.snejk;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Snejk extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = 320;
	public static final int SCALE = 2;
	
	private Thread thread;
	
	private static boolean keepRunning = true;
	private static boolean keepAi = true;
	
	private Handler handler;
	private Player player;
	private AI ai;
	
	public Snejk() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		//handler.addObject(new Body(0, 0, ID.Body));
		//handler.addObject(new Body(0, 0, ID.Body));
		//handler.addObject(new Body(0, 0, ID.Body));
	}

	public synchronized void start() {
		thread = new Thread(this, "Game thread");
		thread.start();
		System.out.println("start");
	}
	
	public synchronized void stop() {
		System.out.println("Game over");
		setKeepRunning(false);
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 10.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isKeepRunning()) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(isKeepRunning()) {
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		int screenW = getWidth();
		int screenH = getHeight();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, screenW, screenH);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}

	private void tick() {
		if(handler.object.size() == 0) {
			player = new Player(100, 100, ID.Player);
			handler.addObject(player);
			ai = new AI(handler, player);
			handler.addObject(new Body(100-32, 100, ID.Body));
			handler.addObject(new Body(100-64, 100, ID.Body));
			handler.addObject(new Fruit(228, 228, ID.Fruit));
		}
		if(keepAi) {
			ai.tick();
		}
		handler.tick();
	}

	public static boolean borderCheck(int x, int y) {
		if(x < 0 || x > WIDTH*SCALE || y < 0 || y > HEIGHT*SCALE) {
			//System.out.println("W œciane wjecha³");
			return true;
		} else {
			return false;
		}
	}

	
	public static void main(String[] args) {
		Snejk gameComponent = new Snejk();
		
		JFrame frame = new JFrame("Snejk");

		frame.add(gameComponent);
		//frame.setLayout(new GridLayout());
		//frame.add(new JButton("cwel"));
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		gameComponent.start();
		
	}

	public static boolean isKeepRunning() {
		return keepRunning;
	}

	public static void setKeepRunning(boolean keepRunning) {
		Snejk.keepRunning = keepRunning;
	}
	
	public static boolean isAi() {
		return keepAi;
	}

	public static void setAi(boolean keepAi) {
		Snejk.keepAi = keepAi;
	}
}

