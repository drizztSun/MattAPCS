import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Chess {
	
	private Piece[][] board = new Piece[8][8];
	private Boolean[][] threat = new Boolean[8][8];
	private int[] dir = {-1, 0, 1, 0, -1};
	private int[] dirdiag = {-1, -1, 1, 1, -1};
	private int[] dirall = {1, -1, -1, 0, 1, 0, -1, 1, 1};
	private int[] dirknight = {2, -1, -2, 1, 2, 1, -2, -1, 2};//i hope this is right
	private HashMap<Character, ArrayList<int[]>> positions;
	
	/*
	notes:
	
	0, 0 will be a8, the leftmost black rook
	
	first number = number, second number = letter
	
	color = "true" ===> Black, White if otherwise
	*/
	
	Chess() {
		setup();
	}
	
	public void test() {

	    for(int i = 0; i < 8; i++)
	        for(int j = 0; j < 8; j++)
	            board[i][j] = null;

	    board[7][4] = new Piece('K', false); 
	    board[7][3] = new Piece('Q', false); 
	    board[6][4] = new Piece('P', false); 
	    board[6][5] = new Piece('Q', true); 
	    //board[6][3] = new Piece('P', false); 

	    board[4][7] = new Piece('Q', true);  
	    board[3][2] = new Piece('B', true);  
	    showboard();
	    System.out.println(inCheckmate(false)); // should print true
	}
	
	
	private void setup() {
		board[0][0] = new Piece('R', true); board[0][7] = new Piece('R', true);//black		
		board[0][1] = new Piece('N', true); board[0][6] = new Piece('N', true);	
		board[0][2] = new Piece('B', true); board[0][5] = new Piece('B', true);	
		board[0][3] = new Piece('Q', true); board[0][4] = new Piece('K', true);	
		for(int i = 0; i<8; i++) board[1][i] = new Piece('P', true);
		
		
		board[7][0] = new Piece('R', false); board[7][7] = new Piece('R', false);//white
		board[7][1] = new Piece('N', false); board[7][6] = new Piece('N', false);
		board[7][2] = new Piece('B', false); board[7][5] = new Piece('B', false);
		board[7][3] = new Piece('Q', false); board[7][4] = new Piece('K', false);
		for(int i = 0; i<8; i++) board[6][i] = new Piece('P', false);
		
	}
	
	public void showboard() {
		
		System.out.println("  -+-+-+-+-+-+-+-");
		for(int i = 0; i<8; i++) {
			System.out.print(8-i);
			System.out.print('|');
			
			for(int j = 0; j<8; j++) {
				Piece curpiece = board[i][j];
				if(curpiece == null) {
					System.out.print("#");
				}else {
					if(curpiece.color()) {
						System.out.print(curpiece.type());
					}
					else {
						System.out.print(Character.toLowerCase(curpiece.type()));
					}
				}
				System.out.print('|');
			}
			System.out.println();
			System.out.println("  -+-+-+-+-+-+-+-");
		}
		System.out.println("  a b c d e f g h");
	}
	
	private int canmove(int i, int j, int newi, int newj, Boolean move){
		//check if the piece on i, j can move to newi, newj. If "move" is false this means it is used for capature checks
		// 2:oversight
		// 1:can move
		// 0:move illegal based on chess rules
		// -1: i, j dosent exist(should not happen)
		// -2: newi, newj is occupied(should not happen)
		// -3:out of bounds(should not happen)
		if(board[i][j] == null) {
			return -1;
		}
		if(move && board[newi][newj] != null) {
			return -2;
		}
		
		if(!move && board[i][j].color() == board[newi][newj].color()) {
			return 0;
		}
		
		Piece p = board[i][j];
		String m = p.moveset();
		int found = 0;
		for(int a = 0; a<m.length(); a++) {
			char c = m.charAt(a);
			if(c == 'f') {
				if(move) {
					if(p.color()) {
						if(newi == i+1 && newj == j) {
							return 1;
						}
						else if(p.hasmoved() && (newj == j && (newi == i+2 || newi == i+1))){
								return 1;
						}else {
							return 0;
						}
					}else {
						if(newi == i-1 && newj == j) {
							return 1;
						}
						else if(p.hasmoved() && (newj == j && (newi == i-2 || newi == i-1))){
								return 1;
						}else {
							return 0;
						}
					}
				}else {
					if(p.color()) {
						if(newi == i+1 && (newj == j+1 || newj == j-1)) {
							return 1;
						}else {
							return 0;
						}
					}else {
						if(newi == i-1 && (newj == j+1 || newj == j-1)) {
							return 1;
						}else {
							return 0;
						}
					}
				}
				
			}else if(c == 'k') {
				for(int b = 0; b<8; b++) {
					int ni = i+dirall[b], nj = j+dirall[b+1];
					if(nj >= 8 || ni >= 8 || nj < 0 || ni < 0)continue;
					if(newi == ni && newj == nj) {
						found = 1;
					}
				}
				return found;
			}else if(c == 'D') {
				for(int d = 0; d<3; d++) {
					for(int b = 1; b<=8; b++) {
						int ni = i+b*dirdiag[d], nj = j+b*dirdiag[d+1];
						if(nj >= 8 || ni >= 8 || nj < 0 || ni < 0) {
							break;
						}
						if(board[ni][nj] != null && (newi != ni || newj != nj)) {
							break;
						}
						if(newi == ni && newj == nj) {
							found = 1;
						}
					}
				}
				
			}else if(c== 'S') {
				for(int b = 0; b<3; b++) {
					for(int d = 1; d<=8; d++) {
						int ni = i+d*dir[b], nj = j+d*dir[b+1];
						if(nj >= 8 || ni >= 8 || nj < 0 || ni < 0)break;
						if(board[ni][nj] != null && (newi != ni || newj != nj)) {
							break;
						}
						if(newi == ni && newj == nj) {
							found = 1;
						}
					}
				}
			}else if(c == 'n') {
				for(int b = 0; b<8; b++) {
					int ni = i+dirknight[b], nj = j+dirknight[b+1];
					if(nj >= 8 || ni >= 8 || nj < 0 || ni < 0)continue;
					if(newi == ni && newj == nj) {
						found = 1;
					}
				}
			}
			
			
		}
		
		
		return found;
		
	}
	
	public int take(int i, int j, int newi, int newj) {
		int p = canmove(i, j, newi, newj, false);
		
		if(p == 1) {
			board[newi][newj] = board[i][j];
			board[i][j] = null;
			return 1;
		}else{
			return p;
		}
	}
	
	public int move(int i, int j, int newi, int newj) {
		int p = canmove(i, j, newi, newj, true);
		
		if(p == 1) {
			board[newi][newj] = board[i][j];
			board[i][j] = null;
			return 1;
		}else{
			return p;
		}
	}
	
	public int[] findKing(Boolean side) {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				Piece p = board[i][j];
				if(p == null)continue;
				if(p.type() == 'K' && p.color() == side) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {-1, -1};//this shouldn't happen. Every side has at least one king
	}
	
	public int startCastle(Boolean side, Boolean longcastle) {//ret:0 = occupied, 1 = successful castle
		int row = side ? 0 : 7; // black = 0, white = 7

		if(board[row][4] == null || !board[row][4].hasmoved()) return 0;

		if(longcastle) { //castle queenside
			if(board[row][0] == null || !board[row][0].hasmoved()) return 0;
			if(board[row][1] != null || board[row][2] != null || board[row][3] != null) return 0;
			board[row][2] = board[row][4]; 
			board[row][3] = board[row][0]; 
			board[row][4] = null;
			board[row][0] = null;
		} else { //castle kingside
			if(board[row][7] == null || !board[row][7].hasmoved()) return 0;
			if(board[row][5] != null || board[row][6] != null) return 0;
			board[row][6] = board[row][4]; 
			board[row][5] = board[row][7]; 
			board[row][4] = null;
			board[row][7] = null;
		}
		return 1;
	}
	
	
	public Boolean isThreatened(int x, int y, Boolean side) {
		Piece buff = board[x][y];
		board[x][y] = new Piece('D', side);//D: dummy piece, only used for certain checks. Cannot move and shouldn't appear for the user
		Boolean res = false;
		
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(board[i][j] == null)continue;
				res |= (canmove(i, j, x, y, false) == 1);//can i, j capture x, y? if yes then it means its threatened
			}
		}
		board[x][y] = buff;
		
		return res;
		
	}
	
	public Boolean inCheckmate(Boolean side) {
		int[] coords = findKing(side);
		int x = coords[0], y = coords[1];

		if(!isThreatened(x, y, side)) return false; //i dont think thjis will ever happen

		// first check if all 9 squares are threatened
		for(int i = 0; i < 8; i++) {
			int newx = x + dirall[i], newy = y + dirall[i+1];
			if(newx >= 8 || newy >= 8 || newx < 0 || newy < 0) continue;
			if(board[newx][newy] != null && board[newx][newy].color() == side) continue; // friendly piece there
			// this is a simulation it will move back
			Piece saved = board[newx][newy];
			board[newx][newy] = board[x][y];
			board[x][y] = null;
			boolean stillThreatened = isThreatened(newx, newy, side);
			board[x][y] = board[newx][newy];
			board[newx][newy] = saved;
			//look at what i told you
			if(!stillThreatened) return false; // king can escape
		}

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece p = board[i][j];
				if(p == null || p.color() != side || p.type() == 'K') continue;
				for(int ni = 0; ni < 8; ni++) {
					for(int nj = 0; nj < 8; nj++) {//this is really stupid but it boils down to moving random pieces to random positions and seeing if check is stopped or not
						if(board[ni][nj] != null && board[ni][nj].color() == side) continue; // friendly->friendly
						boolean capture = board[ni][nj] != null;
						if(canmove(i, j, ni, nj, !capture) != 1) continue;//cant even move
						// simulate the move
						Piece buff = board[ni][nj];
						board[ni][nj] = board[i][j];
						board[i][j] = null;
						int[] kingPos = findKing(side);
						boolean inCheck = isThreatened(kingPos[0], kingPos[1], side);
						board[i][j] = board[ni][nj];
						board[ni][nj] = buff;
						if(!inCheck) return false; //blocks
					}
				}
			}
		}

		return true;
	}
	
	public Boolean isbadMove(int x, int y, int newx, int newy, Boolean side) {//this program ignores if x, y can actually move to newx, newy because there is already a check for it.
		Piece buff = board[x][y];
		Piece newbuff = board[newx][newy];
		Boolean res = false;
		board[newx][newy] = buff;
		
		int[] kpos = findKing(side);
		
		if(isThreatened(kpos[0], kpos[1], side))res =  true;
		board[x][y] = buff;board[newx][newy] = newbuff;
		
		return res;
	}
	
	
	
	
	
	public int[] parsePosition(String s) {
		if(s.length() != 4) {
			return new int[] {-1, -1, -1, -1};//if the person decides to enter some really stupid stuff
		}
		int[] res = new int[]{'8' - s.charAt(1), s.charAt(0)-'a', '8' - s.charAt(3), s.charAt(2)-'a'};
		int x = res[0], y = res[1];
		int newx = res[2], newy = res[3];
		if((x >= 8 || y >= 8 || x < 0 || y < 0) || (newx >= 8 || newy >= 8 || newx < 0 || newy < 0)){
			return new int[] {-1, -1, -1, -1};//if the person decides to enter some really stupid stuff
		}
		return res;
	}
	
	private void help() {
		System.out.println("+This program does NOT use Standard Algebraic Notation. Instead, the program will ask you for the piece you are picking, and where you want to move it");
		System.out.println("+Specify a piece by entering it's coordinates, then choose the point you want to move the piece to");
		System.out.println("+all lowercase letters represent white pieces. All uppercase letters represent Black pieces.");
		System.out.println("+To move a piece from a position to another, enter the piece's position first, then enter the position of the position you want the piece to move to");
		System.out.println("	+For example, moving a pawn from e2 to e4 would be denoted by \"e2e4\".");
		System.out.println("+Short castles are denoted by 0-0, while long castles are denoted by 0-0-0");
	}
	
	public void startGame() {
		Scanner s = new Scanner(System.in);
		Boolean ended = false;
		Boolean turn = false;
		int moves = 0;
		
		while(!ended) {
			showboard();
			System.out.println("================================================================================");
			if(moves == 0)System.out.println("Welcome to chess! make a move to begin(White goes first). enter help for specific info");
			else System.out.println(((turn == true)? "Black" : "White") + "to move. First enter position of piece to pick a piece, then enter position of the piece you want to move to");
			String move = s.nextLine();
			int[] coords = parsePosition(move);
			int x = coords[0], y = coords[1];
			Boolean misinput = false;
			if(x == -1) {
				x = 0; y = 0;
				misinput = true;
			}
			Piece p = board[x][y];
			int castle = 0;//0 = no, 1 = long, -1 = short
			if(move.equals("0-0"))castle = -1;
			else if(move.equals("0-0-0"))castle = 1;
			
			int newx = coords[2], newy = coords[3];
			if(newx == -1) {
				newx = 0; newy = 0;
				misinput = true;
			}
			Piece newp = board[newx][newy];
			
			Boolean capature = board[newx][newy] != null;
			
			Boolean badMove = isbadMove(x, y, newx, newy, turn);
			
			int k = (!capature)? canmove(x, y, newx, newy, true) : canmove(x, y, newx, newy, false);
			int v = 2;
			
			if(castle != 0) {
				v = startCastle(turn, castle == 1);
				if(v == 1)continue;
			}
			
			
			Boolean fail = (capature && p.color() == newp.color()) || 
						   ((x >= 8 || y >= 8 || x < 0 || y < 0) || board[x][y] == null) || 
					       (newx >= 8 || newy >= 8 || newx < 0 || newy < 0 || k == 0) ||
					       (turn != p.color()) ||
					       (move.equals("help")) ||
					       (misinput && castle == 0) ||
					       (badMove) ||
					       (v == 0);
			
			
			while(fail) {
				if(move.equals("help")) {
					help();//help the player
				}else if(v == 0) {
					System.out.print("Castling unavailable");
				}else if(capature && p.color() == newp.color()){
					System.out.print("cannot capture friendly piece");
				}else if(x >= 8 || y >= 8 || x < 0 || y < 0 || board[x][y] == null) {
					System.out.print("Piece selected does not exist or is unreachable");
				}else if(newx >= 8 || newy >= 8 || newx < 0 || newy < 0 || k == 0) {
					System.out.print("Destination out of bounds or is unreachable");
				}else if(turn != p.color()) {
					System.out.println("that isn't your piece, try again");
				}else if(misinput) {
					System.out.println("are you sure you are typing the right thing?");
				}else if(badMove) {
					System.out.println("This move puts the king in danger; choose another move");
				}
		
				misinput = false;
				move = s.nextLine();
				coords = parsePosition(move);
				x = coords[0]; y = coords[1];
				if(x == -1) {
					x = 0; y = 0;
					misinput = true;
				}
				p = board[x][y];
				
				castle = 0;//0 = no, 1 = long, -1 = short
				if(move.equals("0-0"))castle = -1;
				else if(move.equals("0-0-0"))castle = 1;
				
				newx = coords[2]; newy = coords[3];
				if(x == -1) {
					newx = 0; newy = 0;
					misinput = true;
				}
				newp = board[newx][newy];
				capature = board[newx][newy] != null;
				
				k = (!capature)? canmove(x, y, newx, newy, true) : canmove(x, y, newx, newy, false);
				
				badMove = isbadMove(x, y, newx, newy, turn);
				
				if(castle != 0) {
					v = startCastle(turn, castle == 1);
					if(v == 1) {
						
						break;
						
					}
				}
				
				fail = (capature && p.color() == newp.color()) || 
						   ((x >= 8 || y >= 8 || x < 0 || y < 0) || board[x][y] == null) || 
					       (newx >= 8 || newy >= 8 || newx < 0 || newy < 0 || k == 0) ||
					       (turn != p.color()) ||
					       (move.equals("help")) ||
					       (misinput) ||
					       (badMove);
			}
			
			
			if(castle == 0) {
				if(capature) {
					take(x, y, newx, newy);
				}else {
					move(x, y, newx, newy);
				}
			}
			
			
			
			turn = !turn;
			if(inCheckmate(turn)) {
			    showboard();
			    System.out.println((!turn ? "Black" : "White") + " wins!");
			    ended = true;
			}
			moves++;
		}
			
		
	}
	
	public static void main(String[] args) {
		Chess game1 = new Chess();
		
		game1.startGame();
		
		
	}

}


