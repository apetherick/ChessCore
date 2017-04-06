package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Move;
import core.Player;
import core.Position;
import core.PositionList;

public class RookPiece extends Piece {

	public RookPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"WR" : "BR";
	}

public PositionList getLegalMoves() {
		
		//The current position under consideration
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		
		//List of legal positions to return.
		PositionList legalPositions = new PositionList();

		//Array of directions we can move in
		ArrayList<Move> directions = new ArrayList<Move>();
		directions.add(new Move(1,0));
		directions.add(new Move(-1,0));
		directions.add(new Move(0,-1));
		directions.add(new Move(0,1));
		
		//For each direction we can move in, move until we can no longer and record
		//each position
		for(Move move:directions){
			//Move once
			consideredPosition.setPosition(this.getPositionX() + move.deltaX, this.getPositionY() + move.deltaY);
			//check bounds
			while ( consideredPosition.checkWithinBounds() ){
				//find if we've hit another piece
				Piece pieceAtPosition = this.board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY());
				if(pieceAtPosition != null){
					if(pieceAtPosition.getPlayer() == this.getPlayer()){
						//The piece here is ours, can't go any further.
						break;
					} else {
						//this piece here is theirs, we can take this.
						legalPositions.addPosition(consideredPosition);
						break;
					}
				} else {
					//Square is clear, add the position and move again.
					legalPositions.addPosition(consideredPosition);
					consideredPosition.setPosition(consideredPosition.getPositionX() + move.deltaX, consideredPosition.getPositionY() + move.deltaY);
				}
			}
		}
		return legalPositions;
	}

	

	

}
