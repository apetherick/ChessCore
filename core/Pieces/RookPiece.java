package core.Pieces;

import core.Board;
import core.Move;
import core.Player;

public class RookPiece extends Piece {

	public RookPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
		this.moves.add(new Move(0, 1, false, true, true));
		this.moves.add(new Move(1, 0, false, true, true));
		this.moves.add(new Move(0, -1, false, true, true));
		this.moves.add(new Move(-1, 0, false, true, true));

	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"WR" : "BR";
	}

}
