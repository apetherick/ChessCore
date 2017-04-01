package core;

import java.util.ArrayList;

public class Board {
	private ArrayList<Piece> pieces;
	
	public Board(){
		pieces = new ArrayList<Piece>();
		//White Pieces
		pieces.add(new Piece(Player.WHITE, PieceType.ROOK, 0, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.KNIGHT, 1, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.BISHOP, 2, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.QUEEN, 3, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.KING, 4, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.BISHOP, 5, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.KNIGHT, 6, 0));
		pieces.add(new Piece(Player.WHITE, PieceType.ROOK, 7, 0));
		//white pawns
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 0, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 1, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 2, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 3, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 4, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 5, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 6, 1));
		pieces.add(new Piece(Player.WHITE, PieceType.PAWN, 7, 1));
		//Black Pieces
		pieces.add(new Piece(Player.BLACK, PieceType.ROOK, 0, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.KNIGHT, 1, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.BISHOP, 2, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.QUEEN, 3, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.KING, 4, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.BISHOP, 5, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.KNIGHT, 6, 7));
		pieces.add(new Piece(Player.BLACK, PieceType.ROOK, 7, 7));
		//Black pawns
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 0, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 1, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 2, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 3, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 4, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 5, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 6, 6));
		pieces.add(new Piece(Player.BLACK, PieceType.PAWN, 7, 6));
		
	}
	//Gets the piece located at a given position, given by x and y co-ordinates.
	public Piece GetPieceAtPosition(int x, int y){
		for(Piece currentPiece:pieces){
			if(currentPiece.getPositionX() == x && currentPiece.getPositionY()==y){
				return currentPiece;
			}
		}
		return null;
	}
	
	public void printState(){
		//Prints the current state of the board.
		for (int y = Game.maxIndex; y >=0 ; y--){
			String line = Integer.toString(y); 
			for (int x = 0; x <= Game.maxIndex; x++){
				Piece piece = GetPieceAtPosition(x,y);
				if(piece != null){
					line = line + " " + GetPieceAtPosition(x,y).getString();
				}else{
					line = line + "  ";
				}
			}
			System.out.println(line);
		}
		System.out.println("  0 1 2 3 4 5 6 7");
	}

}

/*
*
* 7 R k B Q K B k R
* 6 P P P P P P P P
* 5
* 4 
* 3
* 2
* 1 P P P P P P P P
* 0 R k B Q K B k R
*   0 1 2 3 4 5 6 7
*/