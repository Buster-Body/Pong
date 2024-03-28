import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameGraphics extends JPanel implements Runnable, KeyListener{
	
	static final double height = 720;
	static final double width = 1280;
	static final Dimension SCREEN_SIZE = new Dimension((int)width, (int)height);
	
	Graphics2D g2;
	Paddle player1;
	Paddle player2;
	Thread gameThread;
	
	GameGraphics() {
		this.addKeyListener(this);
		this.setPreferredSize(SCREEN_SIZE);
		this.setFocusable(true);
		player1 = new Paddle(1);
		player2 = new Paddle(2);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		//Game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				delta--;
				
				player1.move();
				player2.move();
				player1.check_bounds();
				player2.check_bounds();
				System.out.println(Paddle.yVel);
				repaint();
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)width, (int)height);
		
		g2 = (Graphics2D) g;
		
		g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.white);
		g2.drawLine((int)width/2, 0, (int)width/2, (int)height);
		g2.drawLine(0, 100, (int)width, 100);
		g2.drawOval(((int)width/2)-150, ((int)height/2)-125, 300, 300);
		
		player1.draw(g2);
		player2.draw(g2);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player1.setUpMovement(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player1.setDownMovement(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player1.setUpMovement(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player1.setDownMovement(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
