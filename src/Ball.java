import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	final int WIDTH = 20, HEIGHT = 20;

	public void draw(Graphics g, int xCoor,int yCoor){
		g.setColor(Color.RED);				// draws ball
		g.fillOval(xCoor, yCoor,WIDTH , HEIGHT);
		g.drawOval(xCoor, yCoor,WIDTH, HEIGHT);
	}


}
