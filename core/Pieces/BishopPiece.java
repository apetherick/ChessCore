package core.Pieces;

import java.util.ArrayList;

import core.PieceType;
import core.Player;
import core.Position;

public class BishopPiece extends Piece {

	public BishopPiece(Player player, int x, int y) {
		super(player, x, y);
	}

	public String getString() {
		return "B";
	}

	@Override
	public ArrayList<Position> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
