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
		//TODO: This move fails, and shouldn't. Fix.
		game.movePiece(0, 3, 1, 4);
		game.printState();
	}

}
