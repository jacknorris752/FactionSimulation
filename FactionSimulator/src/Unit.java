import java.util.ArrayList;

public class Unit {
	
	
	/*
	 * 
	 * TODO:
	 * 
	 */
	

	public Faction myFaction;
	public int myX,myY;
	private int moveRate; //how fast a unit can move per turn probably faction based?
	public static final int size = 20;
	private final int stepSize = 5;
	
	private boolean alive = true;
	
	
	
	private Town target;		//this is where it wants to go
	
	public Unit(Faction fact, int x, int y) {
		this.myFaction = fact;
		this.myX = x;
		this.myY = y;
	}
	
	public void tick() {
		
		if(target == null) {
			search();
		}
		//movement in here
		if(this.myX > target.x) {
			this.myX -= stepSize;
		}else {
			this.myX += stepSize;
		}
		if(this.myY > target.y) {
			this.myY -= stepSize;
		}else {
			this.myY += stepSize;
		}
		System.out.println(this.myX + this.myY);
		//my values go to target values in increments of "stepSize"
		/*System.out.println("I am at: " + this.myX + ", " + this.myY +
				"\n MY target is at: " + target.x + ", " + target.y);*/
		
	}
	
	public void search() {
		//set target to closest town from Map.getTowns();
		
		ArrayList<Town> temp = Map.getTowns();	//list of towns
		Town closest = null;		//temporary closest value
		double closestDistance = 0;
		
		
		if(closest == null) {
			double distance = Engine.distance(this.myX, this.myY, temp.get(0).x,temp.get(0).y);
			closest = temp.get(0);
			closestDistance = distance;
		}
		
		
		for(int i = 0; i < temp.size(); i++) {
			double distance = Engine.distance(this.myX, this.myY, temp.get(i).x,temp.get(i).y);

			if(distance < closestDistance) {
				closest = temp.get(i);
				closestDistance = distance;
			}
		}
		
		target = closest;
	}
	
	
}
