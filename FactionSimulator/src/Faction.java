import java.awt.Color;
import java.util.ArrayList;

public class Faction {
	
	/*
	 * 
	 * TODO: Turns for new unit
	 * TODO: combat stats
	 * TODO: LIST OF TOWNS OWNED? FOR SPAWNING? MAYBE DO THIS IN WORLD?
	 */
	
	public Color myColor;
	private ArrayList<Unit> myUnits = new ArrayList<Unit>();
	
	public Faction(Color col) {
		this.myColor = col;
	}
	
	public void addUnit(int x, int y) {
		myUnits.add(new Unit(this,x,y));		//creating a new unit
	}
	
	public ArrayList<Unit> getFactionUnits(){
		return myUnits;
	}
	
}
