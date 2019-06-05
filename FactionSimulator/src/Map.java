import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Map {

	private static int difference = 200;
	
	
	private static ArrayList<Town> towns = new ArrayList<Town>();
	
	
	/*
	 *TODO: Stop towns from spawning over the edge
	 *TODO:	Stop towns spawning too close to each other
	 */
	
	public static void generateMap(int amount) {
		
		//create new map with "amount" of towns
		for(int i = 0; i < amount; i++) {	
			Boolean acceptable = false;
			Random r = new Random();
			int xResult = 0,yResult = 0;
			while(!acceptable) {
				xResult = r.nextInt(Engine.WIDTH-1)+1;
				yResult = r.nextInt(Engine.HEIGHT-1)+1;
				//checks that current results are not too similar to previous Towns
				for(Town town : towns) {
					if(town.x < xResult + difference) {
						if(town.y < yResult + difference) {
							break;
						}
					}
					if(town.x > xResult - difference) {
						if(town.y > yResult - difference) {
							break;
						}
					}
				}
				acceptable = true;
			}
			
			towns.add(new Town(xResult,yResult));	
		}
		System.out.println("Map.java: number of towns: " + towns.size());
		//towns.add(testTown());		//adds testTown
	}
	
	public static ArrayList<Town> getTowns() {
		//System.out.println("Towns: " + towns.size());
		return towns;
	}
}
