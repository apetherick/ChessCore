package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Player;
import core.Position;

public class RookPiece extends Piece {

	public RookPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
	}

	public String getString() {
		return "R";
	}

	@Override
	public ArrayList<Position> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
