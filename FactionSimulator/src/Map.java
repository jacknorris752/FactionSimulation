import java.util.List;

public class Map {

	private static List<Town> towns;	//needs to be a list
	
	
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
	
	
	
	/*public static List<Town> getTowns() {
		returns list of towns
	}*/
}
