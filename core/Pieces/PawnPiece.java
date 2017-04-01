package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Player;
import core.Position;

public class PawnPiece extends Piece {
	
	private boolean hasMoved;

	public PawnPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
		hasMoved = false;
	}

	public String getString() {
		return "P";
	}

	@Override
	public void setPositionX(int positionX) {
		super.setPositionX(positionX);
		this.hasMoved = true;
	}

	@Override
	public void setPositionY(int positionY) {
		super.setPositionY(positionY);
		this.hasMoved = true;
	}

	@Override
	public ArrayList<Position> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
