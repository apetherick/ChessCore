package test;

import java.util.Scanner;

import core.Game;
import core.InvalidBoardState;

public class Shell {
	public static void main(String[] args) throws NumberFormatException, InvalidBoardState{
		Game game = new Game();
		System.out.println("Starting test");
		game.printState();
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner( System.in );
		while(true){
		        System.out.print("Enter move(" + game.nextPlayer+"): ");
		        String input = keyboard.nextLine();
		        String[] numbersStr = input.split(" ");
		        game.movePiece(Integer.parseInt(numbersStr[0]),
		        		Integer.parseInt(numbersStr[1]), 
		        		Integer.parseInt(numbersStr[2]), 
		        		Integer.parseInt(numbersStr[3])
		        		, false);
		        game.printState();
		}
	}

}