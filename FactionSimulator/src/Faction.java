import java.awt.Color;
import java.util.ArrayList;

public class Faction {
	
	/*
	 * 
	 * TODO: Turns for new unit
	 * 		combat stats
	 * 		
	 */
	
	public Color myColor;
	private ArrayList<Unit> myUnits = new ArrayList<Unit>();
	
	public Faction(Color col) {
		this.myColor = col;
	}
	
}
