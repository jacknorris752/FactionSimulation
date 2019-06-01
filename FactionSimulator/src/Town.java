
public class Town {

	private Faction faction;
	public int x,y;
	
	public Town(int ix, int iy) {
		this.x = ix;
		this.y = iy;
	}
	
	public Faction whatFaction() {
		return this.faction;
	}
	
	public void updateFaction(Faction fact) {
		this.faction = fact;
	}
}
