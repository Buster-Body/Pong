import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	double yPos;
	static double yVel;
	static boolean moveUp, moveDown;
	int PADDLE_WIDTH, PADDLE_HEIGHT, player, x;
	
	
	public Paddle(int player) {
		yVel = 0;
		yPos = ((int)GameGraphics.height/2)-40 + yVel;
		PADDLE_WIDTH = 25;
		PADDLE_HEIGHT = 125;
		
		if(player == 1) {
			x = 40;
		}
		else {
			x = (int)GameGraphics.width-65;
		}
		
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.drawRect(x, (int)yPos, PADDLE_WIDTH, PADDLE_HEIGHT);
		
	}
	
	public void move() {
		yPos += yVel;
		if(moveUp == true) {
			yVel -= 0.25;
		}
		else if (moveDown == true) {
			yVel += 0.25;
		}
		else {
			if (moveUp == false && yVel > 0) {
				yVel -= 0.25;
			}
			else if (moveDown == false && yVel < 0){
				
				yVel += 0.25;
			}
		}
	}
	
	public void check_bounds() {
		if (yPos <= 100) {
			yPos = 100;
		}
		else if (yPos >= (int)GameGraphics.height - PADDLE_HEIGHT-1) {
			yPos = (int)GameGraphics.height - PADDLE_HEIGHT-1;
		}
	}
	
	public void setUpMovement(boolean input) {
		moveUp = input;
	}
	public void setDownMovement(boolean input) {
		moveDown = input;
	}
}
