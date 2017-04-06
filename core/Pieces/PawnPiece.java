package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Move;
import core.Player;
import core.Position;
import core.PositionList;

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
	public void setPosition(int x, int y){
		this.setPositionX(x);
		this.setPositionY(y);
	}

	@Override
	public PositionList getLegalMoves() {
		PositionList positions = new PositionList();
		int directionMultiplier = this.getPlayer()==Player.WHITE ? 1 : -1;
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		//1 forwards
		consideredPosition.setPositionY(consideredPosition.getPositionY() + (1*directionMultiplier));
		if(consideredPosition.checkWithinBounds() && board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) == null){
			positions.addPosition(consideredPosition);
			//we know we've got a clear space ahead. If we can move one, maybe we can move 2
			if(!this.hasMoved){
				consideredPosition.setPositionY(consideredPosition.getPositionY() + (1*directionMultiplier));
				if(consideredPosition.checkWithinBounds() && board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) == null){
					positions.addPosition(consideredPosition);
				}
			}
		}
		//diagonal left
		consideredPosition.setPosition(this.getPositionX() - 1, this.getPositionY() + (1*directionMultiplier));
		if(
				consideredPosition.checkWithinBounds() &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) != null &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()).getPlayer() != this.getPlayer()
				){
			positions.addPosition(consideredPosition);
		}
		//diagonal right
		consideredPosition.setPosition(this.getPositionX() + 1, this.getPositionY() + (1*directionMultiplier));
		if(
				consideredPosition.checkWithinBounds() &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) != null &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()).getPlayer() != this.getPlayer()
				){
			positions.addPosition(consideredPosition);
		}
		return positions;
	}

	

}
