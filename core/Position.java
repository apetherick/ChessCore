package core;

public class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setPositionX(int x){
		this.x = x;
	}
	
	public void setPositionY(int y){
		this.y = y;
	}
	
	public int getPositionX(){
		return this.x;
	}
	
	public int getPositionY(){
		return this.y;
	}
	
	public boolean checkWithinBounds(){
		return (this.x >= 0 &&
				this.x <= Game.maxIndex &&
				this.y >= 0 &&
				this.y <= Game.maxIndex);
	}

}
