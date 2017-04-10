package core;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class PositionList extends ArrayList<Position> {

	public PositionList() {
		// TODO Auto-generated constructor stub
	}

	public PositionList(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public PositionList(Collection<? extends Position> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public boolean containsChessPosition(Position pos){
		for(Position position:this){
			if (position.getPositionX() == pos.getPositionX() && position.getPositionY() == pos.getPositionY()){
				return true;
			}
		}
		return false;
	}
	
	public void addPosition(Position pos){
		this.add(new Position(pos.getPositionX(), pos.getPositionY()));
	}

}
