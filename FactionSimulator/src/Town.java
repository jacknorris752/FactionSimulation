
public class Town {

	private Faction faction;
	public int x,y;
	
	public Town(int ix, int iy) {
		x = ix;
		y = iy;
	}
	
	public Faction whatFaction() {
		return faction;
	}
	
	public void updateFaction(Faction fact) {
		faction = fact;
	}
}
