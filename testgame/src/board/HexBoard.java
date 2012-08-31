package board;

import java.util.ArrayList;
import java.util.List;

public class HexBoard {

	private final List<List<Tile>> board;

	private final Tile[][] board2;

	public HexBoard() {
		board = new ArrayList<List<Tile>>();
		board2 = new Tile[10][10];

		initBoard(10, 10);
	}

	private void initBoard(int rows, int cols) {

		for (int x = 0; x < cols; x++) {
			ArrayList<Tile> row = new ArrayList<Tile>();

			for (int y = 0; y < rows; y++) {
				row.add(newHexTile());
				board2[x][y] = newHexTile();
			}

			board.add(row);
		}

		linkBoard();

	}

	private void linkBoard() {

		for (int x = 0; x < board.size(); x++) {
			ArrayList<Tile> row = (ArrayList<Tile>) board.get(x);
			for (int y = 0; y < row.size(); y++) {
				Tile t = row.get(y);

				if (x == 0) {
					t.addEdge(Direction.Southwest, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Southeast, Edge.EdgeofBoard(t));
				} else if (x == board.size() - 1) {
					t.addEdge(Direction.Northwest, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Northeast, Edge.EdgeofBoard(t));
				}

				if (y == 0) {
					t.addEdge(Direction.West, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Southwest, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Northwest, Edge.EdgeofBoard(t));
				} else if (y == row.size() - 1) {
					t.addEdge(Direction.East, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Southeast, Edge.EdgeofBoard(t));
					t.addEdge(Direction.Northeast, Edge.EdgeofBoard(t));
				}
			}
		}

	}

	private boolean isHexDirection(Direction d) {
		return !(d == Direction.East || d == Direction.West);
	}

	private Tile newHexTile() {

		Tile t = new Tile();

		for (Direction d : Direction.values()) {
			if (isHexDirection(d)) {
				t.addEdge(d, null);
			}
		}

		return t;
	}

}
