import java.awt.Color;
import java.util.ArrayList;

public class World {

	/*
	 * 
	 * TODO:
	 * 
	 * 		needs to hold turns since last spawn for each faction
	 * 
	 */
	
	private static ArrayList<Faction> factions = new ArrayList<Faction>();
	private static ArrayList<Unit> allUnits = new ArrayList<Unit>();
	
	public static void createFactions(int num) {
		for(int i = 0; i < num; i++) {
			
			Color give = null;
			int startX = 0,startY = 0;
			
			switch(i) {
			case 0: give = Color.RED;startX = 20; startY = 20;
			break;
			case 1: give = Color.BLUE;startX = Engine.WIDTH - 20; startY = 20;
			break;
			case 2: give = Color.GREEN;startX = 20; startY = Engine.HEIGHT - 20;
			break;
			case 3: give = Color.PINK;startX = Engine.WIDTH - 20; startY = Engine.HEIGHT - 20;
			break;
			}
			
			
			factions.add(new Faction(give));
			factions.get(i).addUnit(startX, startY);
				
		}
	}
	
	
	public static void addUnit(Faction fact, int x, int y) {
		fact.addUnit(x,y);
	}
	
	public static ArrayList<Unit> getAllUnits() {
		allUnits.clear();
		for(Faction fact : factions) {
			allUnits.addAll(fact.getFactionUnits());
		}
		//System.out.println("I AM: " + allUnits.size());
		return allUnits;
	}
	
}
