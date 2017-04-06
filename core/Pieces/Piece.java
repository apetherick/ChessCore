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

	public Piece(Player player, int x, int y, Board board){
		this.player = player;
		this.position = new Position(x,y);
		this.board = board;
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
	
	public abstract PositionList getLegalMoves();
	
	public PositionList getLegalMoves2(){
		Position consideredPosition = new Position(this.getPositionX(), this.getPositionY());
		
		PositionList legalPositions = new PositionList();

		//Try each move...
		for(Move move:this.moves){
			consideredPosition.setPosition(consideredPosition.getPositionX() + move.deltaX, consideredPosition.getPositionY() + move.deltaY);
		}
		return legalPositions;

	}
	
	
	public String toString(){
		return this.getPlayer() + this.getClass().getName() + " at "+this.getPositionX() + ","+this.getPositionY()+"\r\n"; 
	}
	
}
