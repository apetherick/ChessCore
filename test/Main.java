package test;

import core.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Starting test");
		game.printState();
		game.movePiece(0, 1, 0, 3);
		game.printState();
		game.movePiece(1, 6, 1, 4);
		game.printState();
		game.movePiece(0, 3, 1, 4);
		game.printState();
		game.movePiece(0, 6, 0, 5);
		game.movePiece(3,1,3,3);
		game.movePiece(0, 5, 0, 4);
		game.movePiece(2, 0, 5, 3);
		game.movePiece(0, 4, 0,3);
		game.movePiece(5, 3, 4, 4);
		game.printState();
	}

}
