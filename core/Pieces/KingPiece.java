package core.Pieces;

import java.util.ArrayList;

import core.PieceType;
import core.Player;
import core.Position;

public class KingPiece extends Piece {

	public KingPiece(Player player, int x, int y) {
		super(player, x, y);
	}

	public String getString() {
		return "K";
	}

	@Override
	public ArrayList<Position> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
