package core.Pieces;

import java.util.ArrayList;

import core.PieceType;
import core.Player;
import core.Position;

public abstract class Piece {
	private Player player;
	private Position position;

	public Piece(Player player, int x, int y){
		this.player = player;
		this.position = new Position(x,y);
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
	
	public abstract ArrayList<Position> getLegalMoves();
	
}
