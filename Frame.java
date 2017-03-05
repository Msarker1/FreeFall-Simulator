import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Frame(){
		setLayout( new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FREEFALL-SIMULATION By: MOHAMMAD SARKER");
		setResizable(false);
		start();
	}
	
	public void start(){
		FreeFallListener free = new FreeFallListener();
		add(free);
		pack();
		setLocationRelativeTo(null);
		
	}
}
