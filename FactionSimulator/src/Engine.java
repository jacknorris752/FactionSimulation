import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine implements Runnable{

	public final int WIDTH = 1000;
	public final int HEIGHT = 800;
	
	final int msBetweenFrames = 500;
	
	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	
	//entry point
	public static void main(String[] args) {
		//collect simulation details
		
		//generates new map
		Map.generateMap(3);
		
		
		Engine ex = new Engine();
		new Thread(ex).start();
		//repeat?
	}

	//handles JFrame and canvas initialisation
	public Engine() {
		frame = new JFrame("Faction Simulator");
		
		JPanel panel = (JPanel) frame.getContentPane();
	    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	    panel.setLayout(null);
	      
	    canvas = new Canvas();
	    canvas.setBounds(0, 0, WIDTH, HEIGHT);
	    canvas.setIgnoreRepaint(true);
	     
	    panel.add(canvas);
	      
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setResizable(false);
	    frame.setVisible(true);
	      
	    canvas.createBufferStrategy(2);
	    bufferStrategy = canvas.getBufferStrategy();
	      
	    canvas.requestFocus();
	}
	
	boolean running = true;
	
	double previous = System.currentTimeMillis();
	double lag = 0.0;
	
	@Override
	public void run() {
		
		//start of game loop
		while(running) {
			double current = System.currentTimeMillis();
			double elapsed = current - previous;
			previous = current;
			lag += elapsed;
			//inputs
			
			//delay
			while(lag >= msBetweenFrames) {
				update();
				lag -= msBetweenFrames;
			}
			render();
		}
	}

	//null
	private void processInput() {
		
	}
	
	//updates game logic
	private void update() {
		//World class accessed here
		//collision, if battle run from here or if unit hits town update that towns faction or not
	}
	
	//clears and updates screen
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
	    g.clearRect(0, 0, WIDTH, HEIGHT);
	    draw(g);
	    bufferStrategy.show();
	    g.dispose();
	}
	
	//draw graphics here
	private void draw(Graphics2D g) {
		g.setColor(Color.RED);
		for(Town town : Map.getTowns()) {
			if(town.whatFaction() == null) {
				g.setColor(Color.LIGHT_GRAY);
			}else {
				g.setColor(town.whatFaction().myColor);
			}
			g.fillRect(town.x, town.y, 40, 40);
		}
		
		
		
	}

}


/*
 * Initial game-loop created with code extracts from: http://www.java-gaming.org/index.php?topic=21919.0 accessed:[01/06/2019]
 * 
 */
