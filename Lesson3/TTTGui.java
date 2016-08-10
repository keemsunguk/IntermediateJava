package Lesson3;

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class TTTGui extends GraphicsProgram {

	final int ROW = 3;
	final int COL = 3;
	GRect [][] board;
	private GPoint c;
	private double side = 0;

	
	public void init() {
		//println("Tic Tac Toe");
		setSize(400,400);
		setTitle("Tic Tac Toe");
		board = new GRect[ROW][COL];
		c = new GPoint(getWidth()/2, getHeight()/2);
		side = (Math.min(getWidth(), getHeight())- 100)/3;
	}
	
	private void SetBoard() {
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COL; j++) {
				board[i][j] = new GRect((c.getX()-side*1.5)+side*i, (c.getY()-side*1.5)+side*j, side, side);
				board[i][j].setFilled(true);
				if( (i*ROW+j)%2 == 0 ) {
					board[i][j].setColor(Color.YELLOW);
				} else {
					board[i][j].setColor(Color.LIGHT_GRAY);
				}
				add(board[i][j]);
			}
		}
	}
	
	public void run() {
		SetBoard();
	}
	
}
