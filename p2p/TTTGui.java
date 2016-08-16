package p2p;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class TTTGui extends GraphicsProgram {

	final int ROW = 3;
	final int COL = 3;
	GRect [][] board;
	GObject clickedObj;
	private GPoint c;
	private double side = 0;
	
	private TTT ttt;
	private String currentMove = "X";
	private GLabel currentTurn;
	private GLabel xMark = new GLabel("X");
	private GLabel oMark = new GLabel("O");
	
	public void init() {
		//println("Tic Tac Toe");
		ttt = new TTT();
		setSize(400,400);
		setTitle("Tic Tac Toe");
		board = new GRect[ROW][COL];
		c = new GPoint(getWidth()/2, getHeight()/2);
		side = (Math.min(getWidth(), getHeight())- 100)/3;
		currentTurn = new GLabel(currentMove+" turn");
		currentTurn.setFont("Arial-Bold-16");
		
		xMark.setFont("Arial-Bold-72");
		xMark.setColor(Color.BLUE);
		oMark.setFont("Arial-Bold-72");
		oMark.setColor(Color.RED);
		
		addMouseListeners();
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
	
	public void mouseClicked(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		clickedObj = getElementAt(x,y);

		GPoint sel = new GPoint(clickedObj.getX()+clickedObj.getWidth()/2,
								clickedObj.getY()+clickedObj.getHeight()/2);
		if(currentMove.equals("X") ) {
			currentMove = "O";
			add(xMark, sel.getX()-xMark.getWidth()/2, sel.getY()+xMark.getHeight()/4);
		} else {
			currentMove = "X";
			add(oMark, sel.getX()-oMark.getWidth()/2, sel.getY()+oMark.getHeight()/4);			
		}
		
	}
	public void run() {
		add(currentTurn, c.getX()-currentTurn.getWidth()/2, 20);
		SetBoard();
	}
	
}
