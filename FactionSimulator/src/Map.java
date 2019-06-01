import java.awt.Color;
import java.util.ArrayList;

public class Map {

	private static ArrayList<Town> towns = new ArrayList<Town>();	//needs to be a list
	
	
	/*
	 * 
	 *TODO: create a list of towns 
	 * perhaps throw in one wierd faction to test detection?
	 */
	
	//creates a test town and returns it
	public static Town getTesttown() {
		Town test = new Town(50,50);
		return test;
	}
	
	public static void generateMap(int amount) {
		//create new map with "amount" of towns
		for(int i = 0; i < amount; i++) {
			towns.add(new Town((50*(i+1)),50));	
		}
		Faction yes = new Faction();
		yes.myColor = Color.BLUE;
		Town newTown = new Town(50,100);
		newTown.updateFaction(yes);
		towns.add(newTown);
	}
	
	public static ArrayList<Town> getTowns() {
		return towns;
	}
}
