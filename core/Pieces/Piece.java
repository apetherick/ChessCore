package core.Pieces;

import java.util.ArrayList;

import core.Board;
import core.Move;
import core.Player;
import core.Position;
import core.PositionList;

public abstract class Piece {
	private Player player;
	private Position position;
	protected ArrayList<Move> moves;
	
//	In order to calculate valid moves, we need a back reference to the board.
//	This is a bit nasty, but don't want masses of logic in the board class.
	protected Board board;
	protected Boolean taking = false;

	public Piece(Player player, int x, int y, Board board){
		this.player = player;
		this.position = new Position(x,y);
		this.board = board;
		this.moves = new ArrayList<Move>();
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public void setPosition(int x, int y){
		this.setPositionX(x);
		this.setPositionY(y);
	}

	public int getPositionX() {
		return position.getPositionX();
	}

	public void setPositionX(int x) {
		this.position.setPositionX(x);
	}

	public int getPositionY() {
		return this.position.getPositionY();
	}

	public void setPositionY(int y) {
		this.position.setPositionY(y);
	}
	
	public abstract String getString();
	
	public boolean checkMove(Piece piece, Position position, boolean mayTake, boolean mustTake){
		Piece pieceAtPosition = this.board.GetPieceAtPosition(position.getPositionX(), position.getPositionY());
		if (pieceAtPosition != null){
			if(pieceAtPosition.getPlayer() == this.getPlayer()){
				//our piece is there
				return false;
			}else{
				if((mayTake || mustTake)){
					//other player piece there, and we can take
					this.taking = true;
					return true;
				}else{
					//other players piece there, but this move may not take
					return false;
				}
				
			}
		}else{
			if (!mustTake){
				return true;
			}
		}
		return false;
	}
	
	public PositionList getLegalMoves(){
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		
		PositionList legalPositions = new PositionList();

		//Try each move...
		for(Move move:this.moves){
			consideredPosition.setPosition(this.getPositionX() + move.deltaX, this.getPositionY() + move.deltaY);
			//Do it once
			boolean didOnce = false;
			if(consideredPosition.checkWithinBounds() && checkMove(this, consideredPosition, move.mayTake, move.mustTake)){
				legalPositions.addPosition(consideredPosition);
				didOnce = true;
			}
			
			//do it again?
			consideredPosition.setPosition(consideredPosition.getPositionX() + move.deltaX, consideredPosition.getPositionY() + move.deltaY);
			while ( consideredPosition.checkWithinBounds() && move.repeatable && didOnce && !taking){
				if(checkMove(this, consideredPosition, move.mayTake, move.mustTake)){
					legalPositions.addPosition(consideredPosition);
					consideredPosition.setPosition(consideredPosition.getPositionX() + move.deltaX, consideredPosition.getPositionY() + move.deltaY);

				}else{
					break;
				}
			}
		}
		taking = false;
		
		return legalPositions;

	}
	
	
	public String toString(){
		return this.getPlayer() + " " + this.getClass().getSimpleName() + " at "+this.getPositionX() + ","+this.getPositionY(); 
	}
	
}
