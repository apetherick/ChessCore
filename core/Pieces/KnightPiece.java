package core.Pieces;

import java.util.ArrayList;

import core.PieceType;
import core.Player;
import core.Position;

public class KnightPiece extends Piece {

	public KnightPiece(Player player, int x, int y) {
		super(player, x, y);
	}

	public String getString() {
		return "k";
	}

	@Override
	public ArrayList<Position> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
