package p2p;

import java.util.Scanner;

public class TTT {
	public String [][] board = null;
	
	private static final int ROWS = 3; 
	private static final int COLS = 3; 
	private static String SPACE = " ";
	
	/*
	 * Constructor
	 */
	TTT() { 
		board = new String[ROWS][COLS];
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				board[i][j] = SPACE;
			}
		}
	}
	
	/*
	 * Name: toString
	 * @return String version of board
	 * 
	 */
	public String toString() {
		String local_board = "";
		
		for(int i = 0; i < ROWS; i++) {
			local_board += "\n+---+---+---+\n|";
			for(int j = 0; j < COLS; j++) {
				local_board = local_board + " "+board[i][j]+" |";
			}
		}
		local_board += "\n+---+---+---+\n";
		
		return local_board;
	}
	
	/*
	 * Name: numMoves
	 * @return  Returns number of occupied locations
	 */
	public int numMoves() {
		int local_occupied = 0;
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if( board[i][j] != SPACE) {
					local_occupied++;
				}
			}
		}
				
		return local_occupied;
	}
	
	/*
	 * Name isValid
	 * @param: row, col poistion vector
	 * @return: true if the location is SPACE
	 */
	private boolean isValid(int row, int col) {	
		
		if( row < 0 || row > 2) {
			return false;
		}
		
		if( col < 0 || col > 2) {
			return false;
		}
	
		if(board[row][col] == SPACE) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Name hasWon
	 * @param XorO
	 * @return true if X or O appears three in a row
	 */
	public boolean hasWon(String XorO) {
		
		if( (board[0][0] == XorO) &&
			(board[0][1] == XorO) &&
			(board[0][2] == XorO) ) {
			return true;
		}
		
		if( (board[1][0] == XorO) &&
			(board[1][1] == XorO) &&
			(board[1][2] == XorO) ) {
			return true;
		}

		
		//do the rest of 8 cases
		
		return false;
	}
	
	/* Name isDraw 
	 * @param
	 * @return true if the game is a draw
	 */
	public boolean isDraw() {
		int local_occupied = numMoves();
		
		if( local_occupied == COLS*ROWS) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 
	 */
	public void makeMove(String XorO) {
		System.out.println("Please Enter Your Move: ");
		boolean inputValid = false;
        Scanner scan = new Scanner(System.in);
        
        int row = 0;
        int col = 0;
        
		while(!inputValid) {
			System.out.print("Row:"); 
			row =scan.nextInt();
			System.out.print("Col:");
			col =scan.nextInt();
			
			if(isValid(row, col)) {
				inputValid = true;
			} else {
				System.out.print("Invalid entry. Please reenter");				
			}
		}
		scan.close();
		set(row, col, XorO);
	}
	
	/*
	 * 
	 */
	private void set(int row, int col, String XorO) {
		board[row][col] = XorO;	
	}
}

