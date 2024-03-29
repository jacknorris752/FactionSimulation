import java.util.ArrayList;

public class Unit {

	/*
	 * 
	 * TODO: Rewrite search function so that units don't go for the "nearest" but chooses from the top 3 nearest? avoids all units going to the same on
	 * TODO: if already friendly get new
	 */
	

	public Faction myFaction;
	public int myX,myY;
	public static final int size = 20;
	private final int stepSize = 5;
	//TODO: Make this a step size max so no more jittery movement
	
	private boolean alive = true;
	
	private Town target;		//this is where it wants to go
	
	public Unit(Faction fact, int x, int y) {
		this.myFaction = fact;
		this.myX = x;
		this.myY = y;
	}
	
	//tick is called once per game cycle
	public void tick() {
		
		if(target == null || target.whatFaction() == this.myFaction) {
			search();
		}
		
		//move towards target
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
		
		//take a town
		if(Engine.distance(this.myX, this.myY, target.x, target.y) < 5.0) {
			Battle.takeTown(target, myFaction);
			target = null;
			//search();
		}
		
	}
	
	//set target to closest town from Map.getTowns();
	public void search() {
		
		ArrayList<Town> temp = Map.getTowns();	//list of towns
		Town closest = null;		//temporary closest value
		double closestDistance = 0;
		//System.out.println("Unit.java: temp list is how long: " + temp.size());
		
		/*if(closest == null) {
			double distance = Engine.distance(this.myX, this.myY, temp.get(0).x,temp.get(0).y);
			closest = temp.get(0);
			closestDistance = distance;
		}*/
		
		for(int i = 0; i < temp.size(); i++) {
			//System.out.println("Unit.java: Checking temp:" + i);
			double distance = Engine.distance(this.myX, this.myY, temp.get(i).x,temp.get(i).y);
			//System.out.println("Unit.java: I am " + distance + " away from target");
			if(distance < closestDistance && temp.get(i).whatFaction() != this.myFaction || closest == null) {
				//TODO: experimental seccond condition
				if(temp.get(i).whatFaction() != this.myFaction && temp.get(i) != target) {
					closest = temp.get(i);
					closestDistance = distance;
					//System.out.println("Unit.java: New closest target");
				}
				
			}
		}
		try {
			target = closest;
		}catch(Exception e) {
			//System.out.println("Unit.java: Failed to find new targer");
		}
		
		if(target == null) {
			search();
			//System.out.println("No new target set, trying again");
		}
		
		
	}
}
