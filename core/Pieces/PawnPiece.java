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
//		Pawns can move foward 2 spaces for their first move
//		Move forward 1 space  otherwise
//		And take diagonally forward
		int directionMultiplier = this.getPlayer()==Player.WHITE ? 1 : -1;
//		Position under consideration
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		//Try 1 forwards
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
		//WHat about taking pieces?
		consideredPosition.setPosition(this.getPositionX() + 1, this.getPositionY() + (1*directionMultiplier));
		if(
				consideredPosition.checkWithinBounds() &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) != null &&
				board.GetPieceAtPosition(
						consideredPosition.getPositionX(), 
						consideredPosition.getPositionX()
						)
				.getPlayer() != this.getPlayer()
				){
			positions.addPosition(consideredPosition);
		}
		consideredPosition.setPosition(this.getPositionX() - 1, this.getPositionY() + (1*directionMultiplier));
		if(
				consideredPosition.checkWithinBounds() &&
				board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY()) != null &&
				board.GetPieceAtPosition(
						consideredPosition.getPositionX(), 
						consideredPosition.getPositionX()
						)
				.getPlayer() != this.getPlayer()
				){
			positions.addPosition(consideredPosition);
		}
		System.out.println("Returning the following positions:"+positions);
		return positions;
	}

	

}
