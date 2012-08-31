package board;

import java.util.HashMap;
import java.util.Map;

public class Tile {

	private final Map<Direction, Edge> edges;

	public Tile() {
		edges = new HashMap<Direction, Edge>();
	}

	public void addEdge(Direction d, Edge e) {
		if (edges.get(d) == null) {
			edges.put(d, e);
		}
	}

}
