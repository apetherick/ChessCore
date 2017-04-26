package core;

import core.Pieces.Piece;

public class Game {
	private Board board;
	public static final int maxIndex = 7;
	public Player nextPlayer = Player.WHITE;
	
	public Game(){
		this.board = new Board();
	}
	
	public void movePiece(int x, int y, int newX, int newY, boolean internal) throws InvalidBoardState{
		Piece piece = board.GetPieceAtPosition(x, y);
		if (piece == null){
			System.out.println("No piece at given position");
			return;
		}else{
			System.out.println(piece + " chosen to move to "+ newX + ", "+ newY );
			System.out.println("Legal moves"+ piece.getLegalMoves());
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
				if(! internal){
					if(board.checkForCheck(piece.getPlayer())){
						//This move has put (or kept) our king in check. Undo.
						System.out.println("The king is in check after this move.");
						piece.setPosition(x, y);
						if (taken != null){
							board.addPiece(taken);
						}
						//nasty hack.
						togglePlayer();
					}
					//check if we checkmated the other player.
					if(board.checkForCheckmate(nextPlayer, this)){
						System.out.println("CHECKMATE");
						//TODO : Fools mate can be used to test this.
						// It's not returning the correct moves of the queen
						// and so not picking up on fools mate.
						//Suspect it's identifying a taken piece and then 
						// not bothering to go any further
						//probablt need to reset the "taken" variable.
					}
					//check if we checked the other player
					if(board.checkForCheck(nextPlayer)){
						System.out.println("CHECK");

					}
				}
			}else{
				System.out.println("Invalid move...");
			}
		}
	}
	
	public void togglePlayer(){
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
