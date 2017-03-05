import java.awt.Color;
import java.awt.Graphics;

public class Cannon {
	final int WIDTH = 40, HEIGHT = 20, xCoor = 0, yCoor = 120;
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);	// body of cannon
		g.fillRect(xCoor, yCoor, WIDTH, HEIGHT);
	
		g.setColor(Color.GRAY);			// grey top area
		g.fillRect(xCoor, yCoor, WIDTH, HEIGHT-10);
		
		g.setColor(Color.BLACK);					//WHEELS
		g.fillOval(xCoor, yCoor+20, WIDTH/2, HEIGHT);
		g.setColor(Color.GRAY);
		g.drawOval(xCoor, yCoor+20, WIDTH/2, HEIGHT);
		g.fillOval(xCoor+5, yCoor+25, WIDTH/4, HEIGHT/2);
		
		g.setColor(Color.BLACK);				//WHEELS
		g.fillOval(xCoor+10, yCoor+20, WIDTH/2, HEIGHT);
		g.setColor(Color.GRAY);
		g.drawOval(xCoor+10, yCoor+20, WIDTH/2, HEIGHT);
		g.fillOval(xCoor+15, yCoor+25, WIDTH/4, HEIGHT/2);
		
		g.setColor(Color.GRAY);				// 	head of cannon
		g.drawOval(xCoor+35, yCoor, WIDTH-35, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillOval(xCoor+35, yCoor, WIDTH-35, HEIGHT);
	}
}
