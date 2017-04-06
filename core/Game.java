package core;

import core.Pieces.Piece;

public class Game {
	private Board board;
	public static final int maxIndex = 7;
	public Player nextPlayer = Player.WHITE;
	
	public Game(){
		this.board = new Board();
	}
	
	public void movePiece(int x, int y, int newX, int newY){
		Piece piece = board.GetPieceAtPosition(x, y);
		if (piece == null){
			System.out.println("No piece at given position");
			return;
		}else{
			System.out.println(piece +" chosen to move to "+ newX + ", "+ newY );
			System.out.println(piece.getLegalMoves());
			if(piece.getPlayer() != nextPlayer){
				System.out.println("Wrong Player");
			}
			if(piece.getPlayer() == nextPlayer && piece.getLegalMoves().containsChessPosition(new Position(newX, newY))){
				Piece taken = board.GetPieceAtPosition(newX, newY);
				if(taken != null){
					board.removePiece(taken);
				}
				piece.setPosition(newX, newY);
				togglePlayer();
			}else{
				System.out.println("Invalid move...");
			}
		}
	}
	
	private void togglePlayer(){
		if (nextPlayer == Player.WHITE){
			nextPlayer = Player.BLACK;
		}else{
			nextPlayer = Player.WHITE;
		}
	}

	//Prints the state of the game.
	public void printState() {
		board.printState();
		
	}
}
