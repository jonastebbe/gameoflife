package de.gameoflife.controller;

import de.gameoflife.model.BoardModel;
import de.gameoflife.view.BoardViewConsole;

public class BoardController {

	private BoardModel myBoard;
	// BoardViewSWT myBoardView = new BoardViewSWT(boardSize);
	private BoardViewConsole myBoardView;
	private int boardSize;

	public BoardController() {
		new BoardController(10);
	}

	public BoardController(int boardSize) {
		this.boardSize = boardSize;
		myBoard = new BoardModel(boardSize);
		myBoardView = new BoardViewConsole();
		startGame();
	
	}
	
	private void startGame() {
		int c = 1;
		while (!isGameOver()) {
			System.out.println("Round: " + c + "\n");
			myBoardView.updateView(convertCellArray(), boardSize);
			nextRound();
			c++;
		}
	};

	private boolean[][] convertCellArray() {
		boolean[][] convertedArray = new boolean[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				convertedArray[i][j] = myBoard.getCells()[i][j].isAlive();
			}
		}

		return convertedArray;
	}

	public void nextRound() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				myBoard.statusInNextRound(i, j);
			}
		}
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				myBoard.updateStatus(i, j);
			}
		}
	}

	private boolean isGameOver() {
		return 0 == myBoard.numberOfLivingCells();
	}

}
