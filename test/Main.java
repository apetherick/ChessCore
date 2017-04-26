package test;

import core.Game;
import core.InvalidBoardState;

public class Main {
	public static void main(String[] args) throws InvalidBoardState {
		Game game = new Game();
		System.out.println("Starting test");
		game.printState();
		game.movePiece(0, 1, 0, 3, false);
		game.printState();
		game.movePiece(1, 6, 1, 4, false);
		game.printState();
		game.movePiece(0, 3, 1, 4, false);
		game.printState();
		game.movePiece(0, 6, 0, 5, false);
		game.movePiece(3,1,3,3, false);
		game.movePiece(0, 5, 0, 4, false);
		game.movePiece(2, 0, 5, 3, false);
		game.movePiece(0, 4, 0,3, false);
		game.movePiece(5, 3, 4, 4, false);
		game.printState();
	}

}
