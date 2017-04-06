package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Move;
import core.Player;
import core.Position;
import core.PositionList;

public class KnightPiece extends Piece {

	public KnightPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"Wk" : "Bk";
	}

public PositionList getLegalMoves() {
		
		//The current position under consideration
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		
		//List of legal positions to return.
		PositionList legalPositions = new PositionList();

		//Array of directions we can move in
		ArrayList<Move> directions = new ArrayList<Move>();
		directions.add(new Move(2,-1));
		directions.add(new Move(2,1));
		directions.add(new Move(-2,-1));
		directions.add(new Move(-2,1));

		directions.add(new Move(1,2));
		directions.add(new Move(1,-2));
		directions.add(new Move(-1,2));
		directions.add(new Move(-1,-2));
		//For each direction we can move in,
		for(Move move:directions){
			//Move once
			consideredPosition.setPosition(this.getPositionX() + move.deltaX, this.getPositionY() + move.deltaY);
			Piece pieceAtPosition = this.board.GetPieceAtPosition(consideredPosition.getPositionX(), consideredPosition.getPositionY());
			if(consideredPosition.checkWithinBounds()){
				if(pieceAtPosition != null){
					if(pieceAtPosition.getPlayer() == this.getPlayer()){
						//The piece here is ours, can't go.
						break;
					}else{
						//their piece, can take
						legalPositions.addPosition(consideredPosition);
					}
				}else{
					//no piece
					legalPositions.addPosition(consideredPosition);
				}
			}
		}
		return legalPositions;
	}
	
	

}
