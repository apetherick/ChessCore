package core.Pieces;

import java.util.ArrayList;

import core.PieceType;
import core.Player;
import core.Position;

public class RookPiece extends Piece {

	public RookPiece(Player player, int x, int y) {
		super(player, x, y);
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
