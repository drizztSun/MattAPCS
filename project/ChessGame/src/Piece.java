import java.util.ArrayList;

public class Piece {
	private char type;
	private Boolean color;//true => black
	private Boolean hasntmoved;//important to determine castle+double move pawn
	private String moveset;//where it can move(and therefore capture(note that pawns are a outlier from this rule))
	
	
	
	private void getmoveset() {/*
	
	f:pawn(only 1 square forward)
	S: straight(left right up down), any amount
	D: diagonal, any amount
	k: straight+diagonal, one square only(king only)
	n: knight, ignores los
	
	*/
		if(type == 'P') {
			moveset = "f";
		}
		else if(type == 'R') {
			moveset = "S";
		}
		else if(type == 'B') {
			moveset = "D";
		}
		else if(type == 'Q') {
			moveset = "SD";
		}
		else if (type == 'K') {
			moveset = "k";
		}else {
			moveset = "n";
		}
	}
	
	Piece(char t, Boolean c){
		type = t;
		color = c;
		hasntmoved = true;
		getmoveset();
	}
	
	
	public Boolean hasntmoved() {
		return hasntmoved;
	}
	
	public void move() {
		hasntmoved = false;
	}
	
	public Boolean color() {
		return color;
	}
	
	public char type() {
		return type;
	}
	
	public String moveset() {
		return moveset;
	}
	
	
	public static void main(String[] args) {
		//blah blah
		
		
	}
}
