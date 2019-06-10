import java.awt.Color;
import java.util.ArrayList;

public class Faction {
	
	/*
	 * 
	 * TODO: combat stats
	 * TODO: LIST OF TOWNS OWNED? SHOULD BE DONE HERE, Every add must add but how would take away when lost?
	 */
	
	public String name;
	public Color myColor;
	public int turnsToSpawn;
	private ArrayList<Unit> myUnits = new ArrayList<Unit>();
	
	public Faction(String name,Color col,int turns) {
		this.name = name;
		this.myColor = col;
		this.turnsToSpawn = turns;
	}
	
	public void addUnit(int x, int y) {
		myUnits.add(new Unit(this,x,y));		//creating a new unit
	}
	
	public ArrayList<Unit> getFactionUnits(){
		return myUnits;
	}
	
}
