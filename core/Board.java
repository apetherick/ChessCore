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
	
	//Primary data structure. Stores all the pieces currently on the board.
	private ArrayList<Piece> pieces;
	
	public Board(){
		//Initialise pieces
		pieces = new ArrayList<Piece>();
		//Add first row White Pieces to the board
		pieces.add(new RookPiece(Player.WHITE, 0, 0, this));
		pieces.add(new KnightPiece(Player.WHITE, 1, 0, this));
		pieces.add(new BishopPiece(Player.WHITE, 2, 0, this));
		pieces.add(new QueenPiece(Player.WHITE, 3, 0, this));
		pieces.add(new KingPiece(Player.WHITE, 4, 0, this));
		pieces.add(new BishopPiece(Player.WHITE, 5, 0, this));
		pieces.add(new KnightPiece(Player.WHITE, 6, 0, this));
		pieces.add(new RookPiece(Player.WHITE, 7, 0, this));
		//add white pawns to the board
		pieces.add(new PawnPiece(Player.WHITE, 0, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 1, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 2, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 3, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 4, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 5, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 6, 1, this));
		pieces.add(new PawnPiece(Player.WHITE, 7, 1, this));
		//Black Pieces
		pieces.add(new RookPiece(Player.BLACK, 0, 7, this));
		pieces.add(new KnightPiece(Player.BLACK, 1, 7, this));
		pieces.add(new BishopPiece(Player.BLACK, 2, 7, this));
		pieces.add(new QueenPiece(Player.BLACK, 3, 7, this));
		pieces.add(new KingPiece(Player.BLACK, 4, 7, this));
		pieces.add(new BishopPiece(Player.BLACK, 5, 7, this));
		pieces.add(new KnightPiece(Player.BLACK, 6, 7, this));
		pieces.add(new RookPiece(Player.BLACK, 7, 7, this));
		
		pieces.add(new PawnPiece(Player.BLACK, 0, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 1, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 2, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 3, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 4, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 5, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 6, 6, this));
		pieces.add(new PawnPiece(Player.BLACK, 7, 6, this));
		
	}
	//Gets the piece located at a given position, given by x and y co-ordinates.
	//Returns null is nothing at that position.
	public Piece GetPieceAtPosition(int x, int y){
		for(Piece currentPiece:pieces){
			if(currentPiece.getPositionX() == x && currentPiece.getPositionY()==y){
				return currentPiece;
			}
		}
		return null;
	}
	
	//Prints the current state of the board.
	public void printState(){
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