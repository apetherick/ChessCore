package core;

public class Move {

	public int deltaX;
	public int deltaY;
	public boolean mustTake;
	public boolean mayTake;
	public boolean repeatable;
	
	public Move(int x, int y, boolean mustTake, boolean mayTake, boolean repeatable) {
		this.deltaX = x;
		this.deltaY = y;
		this.mayTake = mayTake;
		this.mustTake = mustTake;
		this.repeatable = repeatable;
	}

}
