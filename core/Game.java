package core;

public class Game {
	private Board board;
	public static final int maxIndex = 7;
	
	public Game(){
		this.board = new Board();
	}

	public void printState() {
		board.printState();
		
	}
}
