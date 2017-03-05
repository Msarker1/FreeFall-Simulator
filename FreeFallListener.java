import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FreeFallListener extends JPanel implements ActionListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int WIDTH = 900 , HEIGHT = 520;
	private int xCoor = 35, yCoor = 120;
	private Ball b;
	private Cannon can;
	private Thread thread;
	private boolean u0,u30,u60 = false;
	private JButton v0, v30, v60, Reset, Distance, Time;
	private double distance, time;

	public FreeFallListener(){
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); // size of board
												// init all variables (JButtons) and adds them to panel
		b = new Ball();
		can = new Cannon();
		v0 = new JButton("Horizontal Velocity: 0(m/s)");
		v30 = new JButton("Horizontal Velocity: 30(m/s)");
		v60 = new JButton("Horizontal Velocity: 60(m/s)");
		Reset = new JButton("Reset"); 
		Distance = new JButton("Distance: "+distance+"m"); 
		Time = new JButton("Time: "+time+" s");
		
		v0.setBackground(Color.GRAY);	// background colors
		v30.setBackground(Color.GRAY);
		v60.setBackground(Color.GRAY);
		
		Distance.setEnabled(false);
		Distance.setBackground(Color.BLACK);
		Time.setEnabled(false);
		Time.setBackground(Color.BLACK);
		
		add(v0);	// adds buttons to panel
		add(v30);
		add(v60);
		add(Reset);
		add(Distance);
		add(Time);
	
		
		v0.addActionListener(this);  // Actionlisteners started
		v30.addActionListener(this);
		v60.addActionListener(this);
		Reset.addActionListener(this);

		start();	// calls start to start thread
	}
	
	public void start(){
		thread = new Thread(this);	
		thread.start();	// thread started
	}
	
	public void updateZero(){
		if(yCoor <420 ){
			v30.setEnabled(false);
			v60.setEnabled(false);
			xCoor = 40;
			yCoor+=14;
		}
		
	}
	
	public void update30(){
		if(yCoor <420 ){
			v0.setEnabled(false);
			v60.setEnabled(false);
			xCoor+=10;
		
			if(xCoor>185)
				yCoor+=17;
		}
	}
	
	public void update60(){
		if(yCoor <420 ){
			v0.setEnabled(false);
			v30.setEnabled(false);
			xCoor+=19;;
			
			if(xCoor>360)
				yCoor+=17;
		}	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);		// draws grid;
		for(int i = 0; i<=HEIGHT;i+=20)
			g.drawLine(0, i, WIDTH, i);
		for(int i = 0; i<=WIDTH; i+=20)
			g.drawLine(i, 0, i, HEIGHT);
		
		Color col = new Color(102, 51, 0);
		g.setColor(col);	// draws the black stand for the ball
		g.fillRect(0, 160,40,WIDTH);
		Color c = new Color(51, 255, 51);
		g.setColor(c);					// draws grass area (green)
		g.fillRect(0, HEIGHT-80, WIDTH, HEIGHT/4);
		g.setColor(Color.BLACK);
		g.drawRect(0, HEIGHT-80, WIDTH, HEIGHT/4);
		g.setColor(Color.BLACK);
		g.drawString("150m", 0, HEIGHT/2);

		int x = 0, xc = 40;			// draws x axis
		for(int j=0;j<=40;j++){
				g.drawString(" "+x+" ", xc, 450);
				 x+=1;
				 xc+=20;
		}
		
		 g.drawString("Each Box Represents 10m", 360, 480);
		 can.draw(g);					// draws cannon
		 b.draw(g, xCoor,yCoor);	// draws the ball
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == v0){			// implements buttons
			u0 = true;
			distance = 0;
			time = 5.53;
			Distance.setText("Distance: " + distance+" m");
			Time.setText("Time: "+ time + " s");
			
		}
		
		if(e.getSource() == v30){
			u30 = true;
			distance = 165.98;
			time = 5.53;
			Distance.setText("Distance: " + distance+" m");
			Time.setText("Time: "+ time + " s");
		}
		
		if(e.getSource() == v60){
			u60 = true;
			distance = 331.97;
			time = 5.53;
			Distance.setText("Distance: " + distance+" m");
			Time.setText("Time: "+ time + " s");
		}
		
		if(e.getSource() == Reset){
			u0 = false;					// resets all  buttons and booleans and clears board
			u30 = false;
			u60 = false;
			
			v0.setEnabled(true);
			v30.setEnabled(true);
			v60.setEnabled(true);
			
			xCoor = 35;
			yCoor = 120;
			distance = 0;
			time = 0;
			Distance.setText("Distance: " + distance+" m");
			Time.setText("Time: "+ time + " s");
		}
		
	}
	@Override
	public void run() {	// repaints loop
		while(true){
			repaint();
			if(u0)
				updateZero();
			if(u30)
				update30();
			if(u60)
				update60();
	
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}}