
public class Unit {
	
	
	/*
	 * 
	 * TODO:
	 * 		how to have an "update" method here?
	 * 
	 */
	

	private Faction myFaction;
	private int myX,myY;
	private int moveRate; //how fast a unit can move per turn probably faction based?
	public static final int size = 20;
	
	private boolean alive = true;
	
	
	
	private Town target;		//this is where it wants to go
	
	public Unit(Faction fact, int x, int y) {
		this.myFaction = fact;
		this.myX = x;
		this.myY = y;
	}
	
	public void update() {
		//if target is null then run search
		//movement in here
	}
	
	//DO ME FIRST
	public void search() {
		//set target to closest town from Map.getTowns();
	}
	
	
}
