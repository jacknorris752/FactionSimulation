
public class Unit {

	private Faction myFaction;
	private int myX,myY;
	private int moveRate; //how fast a unit can move per turn probably faction based?
	public static final int size = 20;
	
	public Unit(Faction fact, int x, int y) {
		this.myFaction = fact;
		this.myX = x;
		this.myY = y;
	}
	
}
