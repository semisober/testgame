package board;

public class Edge {

	final Tile t1, t2;
	boolean isPassable;

	public Edge(Tile t1, Tile t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public Tile getOtherTile(Tile t) {
		return (t.equals(t1) ? t2 : t1);
	}

	public void setPassable(boolean p) {
		isPassable = p;
	}

	static Edge EdgeofBoard(Tile t) {
		Edge e = new Edge(t, null);
		e.setPassable(false);
		return e;
	}

}
