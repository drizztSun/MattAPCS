import java.util.Scanner;

public class MineSweeperBoard {
	
	private int numMines;
	private int numRows;
	private int numCols;
	private String[][] board;
	private boolean[][] flag;
	private boolean gameOver;
	
	public MineSweeperBoard(int r, int c, int m) {
		numMines = m;
		numRows = r;
		numCols = c;
		gameOver = false;
		board = new String[r][c];
		flag = new boolean[r][c];
		for (int row = 0; row < r; row++) {			//row-major order
			for (int col = 0; col < c; col++) {
				board[row][col] = ".";
				flag[row][col] = false;
			}
		}
		//place m mines
		for (int k = 0; k < m; k++) {
			int mineRow = (int)(Math.random() * r);
			int mineCol = (int)(Math.random() * c);
			if (board[mineRow][mineCol].equals("M"))
				k--;
			else
				board[mineRow][mineCol] = "M";
		}
	}
	
	public void displayBoard() {
		for (int row = 0; row < numRows; row++ ) {
			for (int col = 0; col < numCols; col++) {
				if (!gameOver && board[row][col].equals("M")) {
					System.out.print(".");
				}
				else if(flag[row][col] == true) {
					System.out.print("F");
				}else {
					System.out.print(board[row][col]);
				}
					
			}
			System.out.println("");
		}
	}

	public void checkSquare(int x, int y) {
		if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
				&& board[x][y].equals("."))
		{
			int count = 0;
			if (x >= 1 && y >= 1 && board[x - 1][y - 1].equals("M")) count++;
			if (x >= 1 && board[x - 1][y].equals("M")) count++;
			if (x >= 1 && y + 1 < board[0].length && board[x - 1][y + 1].equals("M")) count++;
			if (y>= 1 && board[x][y - 1].equals("M")) count++;
			if (y + 1 < board[0].length && board[x][y + 1].equals("M")) count++;
			if (x + 1 < board.length && y >= 1 && board[x + 1][y - 1].equals("M")) count++;
			if (x + 1 < board.length && board[x + 1][y].equals("M")) count++;
			if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1].equals("M")) count++;
			board[x][y] = "" + count;
			if (count == 0) {
				checkSquare(x - 1, y - 1);
				checkSquare(x - 1, y);
				checkSquare(x - 1, y + 1);
				checkSquare(x, y - 1);
				checkSquare(x, y + 1);
				checkSquare(x + 1, y - 1);
				checkSquare(x + 1, y);
				checkSquare(x + 1, y + 1);
			}
		}
	}
	
	public void flag(int x, int y) {
		if(board[x][y] == "F") {
			flag[x][y] = false;
		}
		flag[x][y] = true;
		
	}
	
	public boolean hasWon() {
		//checks to see whether there are no "."s left on the board
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j].equals(".")) return false;
			}
		}
		return true;
	}
	
	public void solveeverything() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j].equals(".")) {
					board[i][j] = "1";
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MineSweeperBoard game = new MineSweeperBoard(6, 10, 8);

		Scanner kboard = new Scanner(System.in);
		while (!game.gameOver) {
			game.displayBoard();
			System.out.println("Flag or Reveal? F for Flag, R for Reveal");
			String c = kboard.nextLine();
			while(!(c.equals("F") || c.equals("f") || c.equals("R") || c.equals("r") || c.equals(" "))) {
				System.out.println("Incorrect format, try again");
				c = kboard.nextLine();
			}
			
			if(c.equals("R") || c.equals("r")) {
				System.out.println("Enter a row number: ");
				int x = kboard.nextInt();
				System.out.println("Enter a column number: ");
				int y = kboard.nextInt();
				if(x == 0 && y == 0) {
					game.solveeverything();
				}
				if (game.board[x][y].equals("M")) {
					System.out.println("You chose a mine. You lose.");
					game.gameOver = true;
					game.displayBoard();
				}
				else {
					game.checkSquare(x, y);
					if(game.hasWon()) {
						System.out.println("You have revealed every square that is not a mine. You win!");
					}
					
				}
			}else if(c.equals("F") || c.equals("f")) {
				System.out.println("Now flagging. Mark potential mines with a flag or use this on an already flagged point to remove the flag.");
				System.out.println("Enter a row number: ");
				int x = kboard.nextInt();
				System.out.println("Enter a column number: ");
				int y = kboard.nextInt();
				while(!(game.board[x][y].equals("M") || game.board[x][y].equals("."))
						&& game.flag[x][y] == false
						) {
					System.out.println("The square you selected cannot be flagged; try another square");
					System.out.println("Enter a row number: ");
					x = kboard.nextInt();
					System.out.println("Enter a column number: ");
					y = kboard.nextInt();
				}
				game.flag(x, y);
			}
			
		}
	}
}
