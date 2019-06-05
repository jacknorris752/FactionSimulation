import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class World {

	/*
	 * 
	 * TODO: Needs to hold turns since last spawn for each faction
	 * 
	 */
	
	private static ArrayList<Faction> factions = new ArrayList<Faction>();
	private static ArrayList<Unit> allUnits = new ArrayList<Unit>();
	private static int[] turnCounter = new int[] {0,0,0,0};
	
	public static void createFactions(int num,String[] names,Color[] cols) {
		for(int i = 0; i < num; i++) {
			
			Color give = null;
			int startX = 0,startY = 0;
			
			switch(i) {
			case 0: give = cols[i]; startX = 20; startY = 20;
			break;
			case 1: give = cols[i]; startX = Engine.WIDTH - 20; startY = 20;
			break;
			case 2: give = cols[i]; startX = 20; startY = Engine.HEIGHT - 20;
			break;
			case 3: give = cols[i]; startX = Engine.WIDTH - 20; startY = Engine.HEIGHT - 20;
			break;
			}
			
			
			//last value is just for testing LOWEST THIS SHOULD BE IS AROUND 50
			factions.add(new Faction(names[i],give,50));
			factions.get(i).addUnit(startX, startY);
				
		}
	}
	
	//Word tick
	public static void tick() {
		
		for(int i=0; i<factions.size();i++) {
			//temp storage for friendly towns
			ArrayList<Town> temp = new ArrayList<Town>();
			for(Town town : Map.getTowns()) {
				if(town.whatFaction() == factions.get(i)) {
					temp.add(town);
				}
			}
			
			if(temp.size() != 0) {
				turnCounter[i] += 1;
				turn();
			}
			
			if(factions.get(i).turnsToSpawn == turnCounter[i] && temp.size() != 0) {
				//spawn unit at random owned town
				int range = temp.size();
				Random rn = new Random();
				int townIndex = rn.nextInt(range);
				Town t = temp.get(townIndex);
				addUnit(factions.get(i),t.x,t.y);
				
				//reset counter for this faction
				turnCounter[i] = 0;
			}
		}
	}
	
	public static void turn() {
		System.out.println("World.java: turn(): " + turnCounter[0] + " " + turnCounter[1] + " " + turnCounter[2] + " " + turnCounter[3]);
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
