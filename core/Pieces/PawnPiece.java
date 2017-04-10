package core.Pieces;

import java.lang.Math;
import core.Board;
import core.Move;
import core.Player;

public class PawnPiece extends Piece {
	
	public PawnPiece(Player player, int x, int y, Board board) {
		super(player, x, y, board);
		int multiplier = player == Player.WHITE?1:-1;
		this.moves.add(new Move(0, 1 * multiplier, false, false, false));
		this.moves.add(new Move(0, 2 * multiplier, false, false, false));
		this.moves.add(new Move(1, 1 * multiplier, true, true, false));
		this.moves.add(new Move(-1, 1 * multiplier, true, true, false));
	}

	public String getString() {
		return this.getPlayer() == Player.WHITE?"WP" : "BP";
	}

	@Override
	public void setPositionX(int positionX) {
		super.setPositionX(positionX);
		removeDoubleMove();
	}

	@Override
	public void setPositionY(int positionY) {
		super.setPositionY(positionY);
		removeDoubleMove();
	}
	
	@Override
	public void setPosition(int x, int y){
		super.setPosition(x, y);
		removeDoubleMove();
	}
	
	private void removeDoubleMove(){
		if(Math.abs(this.moves.get(1).deltaX) == 2){
			this.moves.remove(1);
		}
	}
}
