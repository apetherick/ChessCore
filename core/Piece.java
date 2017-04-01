package core;

public class Piece {
	private Player player;
	private PieceType type;
	private int positionX;
	private int positionY;
	
	public Piece(Player player, PieceType type, int x, int y){
		this.player = player;
		this.type = type;
		this.positionX = x;
		this.positionY = y;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public String getString(){
		switch(this.type){
			case PAWN:
				return "P";
			case ROOK:
				return "R";
			case KNIGHT:
				return "k";
			case BISHOP:
				return "B";
			case QUEEN:
				return "Q";
			case KING:
				return "K";
		}
		return null;
	}
	
}
