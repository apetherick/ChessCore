package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Player;
import core.Position;
import core.PositionList;

public class KnightPiece extends Piece {

	public KnightPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
	}

	public String getString() {
		return "k";
	}

	@Override
	public PositionList getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
