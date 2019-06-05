import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine implements Runnable{
	
	

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	
	final double msBetweenFrames = 500;
	
	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	
	//entry point
	public static void main(String[] args) {
		Menu m = new Menu();
	}
	
	public static void startSim() {
		Engine ex = new Engine();
		new Thread(ex).start();
	}
	
	//temporary for taking towns
	public static void takeTown(Town t,Faction fact) {
		t.updateFaction(fact);
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
		
		//TODO: GET HOW MANY TOWNS SOMEHOW? MAYBE RNG?
		Map.generateMap(5);
		
		//start of game loop
		while(running) {
			double current = System.currentTimeMillis();
			double elapsed = current - previous;
			previous = current;
			lag += elapsed;
			//System.out.println(lag);
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
		
		//call update in each unit
		for(Unit unit : World.getAllUnits()) {
			unit.tick();
	
		}
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
		for(Town town : Map.getTowns()) {
			if(town.whatFaction() == null) {
				g.setColor(Color.LIGHT_GRAY);
			}else {
				g.setColor(town.whatFaction().myColor);
			}
			g.fillRect(town.x, town.y, Town.size, Town.size);
		}
		
		for(Unit unit : World.getAllUnits()) {
			g.setColor(unit.myFaction.myColor);
			g.fillOval(unit.myX, unit.myY, unit.size, unit.size);
		}
		
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		
		double x = Math.pow(x2 - x1, 2);
		double y = Math.pow(y2 - y1, 2);
		double dist = Math.sqrt(x + y);
		return dist;
	}
	
	public static boolean collisionCheck(Object obj1, Object obj2) {
		return true;
		
		//figures out the two objects centre points and then builds a virtual 4 point box around this based on the width and height of the object.
		//if the two objects intersect then return true otherwise return false
	}

}


/*
 * Initial game-loop created with code extracts from: http://www.java-gaming.org/index.php?topic=21919.0 accessed:[01/06/2019]
 * 
 */
