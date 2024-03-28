import java.awt.Color;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	GameGraphics graphics;
	
	protected Window() {
		
		graphics = new GameGraphics();
		
		this.add(graphics);
		this.setTitle("Pong");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(150, 50);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GREEN);
		this.pack();
		this.setVisible(true);
	}
}
