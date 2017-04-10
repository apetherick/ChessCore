package core.Pieces;

import core.Board;
import core.Move;
import core.Player;

public class KingPiece extends Piece {

	public KingPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
		this.moves.add(new Move(0, 1, false, true, false));
		this.moves.add(new Move(1, 1, false, true, false));
		this.moves.add(new Move(1, 0, false, true, false));
		this.moves.add(new Move(1, -1, false, true, false));
		this.moves.add(new Move(0, -1, false, true, false));
		this.moves.add(new Move(-1, -1, false, true, false));
		this.moves.add(new Move(-1, 0, false, true, false));
		this.moves.add(new Move(-1, 1, false, true, false));
	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"WK" : "BK";
	}
}
