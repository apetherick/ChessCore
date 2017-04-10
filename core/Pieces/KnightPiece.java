package core.Pieces;

import core.Board;
import core.Move;
import core.Player;

public class KnightPiece extends Piece {

	public KnightPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
		
		this.moves.add(new Move(1, 2, false, true, false));
		this.moves.add(new Move(1, -2, false, true, false));
		this.moves.add(new Move(2, -1, false, true, false));
		this.moves.add(new Move(2, 1, false, true, false));
		
		this.moves.add(new Move(-1, 2, false, true, false));
		this.moves.add(new Move(-1, -2, false, true, false));
		this.moves.add(new Move(-2, -1, false, true, false));
		this.moves.add(new Move(-2, 1, false, true, false));
	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"Wk" : "Bk";
	}
}
