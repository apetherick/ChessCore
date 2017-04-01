package core;

import java.util.ArrayList;

import core.Pieces.BishopPiece;
import core.Pieces.KingPiece;
import core.Pieces.KnightPiece;
import core.Pieces.PawnPiece;
import core.Pieces.Piece;
import core.Pieces.QueenPiece;
import core.Pieces.RookPiece;

public class Board {
	private ArrayList<Piece> pieces;
	
	public Board(){
		pieces = new ArrayList<Piece>();
		//White Pieces
		pieces.add(new RookPiece(Player.WHITE, 0, 0));
		pieces.add(new KnightPiece(Player.WHITE, 1, 0));
		pieces.add(new BishopPiece(Player.WHITE, 2, 0));
		pieces.add(new QueenPiece(Player.WHITE, 3, 0));
		pieces.add(new KingPiece(Player.WHITE, 4, 0));
		pieces.add(new BishopPiece(Player.WHITE, 5, 0));
		pieces.add(new KnightPiece(Player.WHITE, 6, 0));
		pieces.add(new RookPiece(Player.WHITE, 7, 0));
		//white pawns
		pieces.add(new PawnPiece(Player.WHITE, 0, 1));
		pieces.add(new PawnPiece(Player.WHITE, 1, 1));
		pieces.add(new PawnPiece(Player.WHITE, 2, 1));
		pieces.add(new PawnPiece(Player.WHITE, 3, 1));
		pieces.add(new PawnPiece(Player.WHITE, 4, 1));
		pieces.add(new PawnPiece(Player.WHITE, 5, 1));
		pieces.add(new PawnPiece(Player.WHITE, 6, 1));
		pieces.add(new PawnPiece(Player.WHITE, 7, 1));
		//Black Pieces
		pieces.add(new RookPiece(Player.BLACK, 0, 7));
		pieces.add(new KnightPiece(Player.BLACK, 1, 7));
		pieces.add(new BishopPiece(Player.BLACK, 2, 7));
		pieces.add(new QueenPiece(Player.BLACK, 3, 7));
		pieces.add(new KingPiece(Player.BLACK, 4, 7));
		pieces.add(new BishopPiece(Player.BLACK, 5, 7));
		pieces.add(new KnightPiece(Player.BLACK, 6, 7));
		pieces.add(new RookPiece(Player.BLACK, 7, 7));
		//Black pawns
		pieces.add(new PawnPiece(Player.BLACK, 0, 6));
		pieces.add(new PawnPiece(Player.BLACK, 1, 6));
		pieces.add(new PawnPiece(Player.BLACK, 2, 6));
		pieces.add(new PawnPiece(Player.BLACK, 3, 6));
		pieces.add(new PawnPiece(Player.BLACK, 4, 6));
		pieces.add(new PawnPiece(Player.BLACK, 5, 6));
		pieces.add(new PawnPiece(Player.BLACK, 6, 6));
		pieces.add(new PawnPiece(Player.BLACK, 7, 6));
		
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