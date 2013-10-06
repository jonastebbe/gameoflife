package de.gameoflife.controller;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.gameoflife.model.BoardModel;
import de.gameoflife.view.BoardViewSWT;

public class BoardController {

	private BoardModel myBoard;
	private BoardViewSWT myBoardView;
	private int boardSize;

	public BoardController() {
		new BoardController(10);
	}

	public BoardController(int boardSize) {
		this.boardSize = boardSize;
		myBoard = new BoardModel(boardSize);
		myBoardView = new BoardViewSWT(boardSize);
		myBoardView.addNextRoundListener(new NextRoundListener());
		myBoardView.addResetGameListener(new ResetGameListener());
		myBoardView.updateView(convertCellArray(), boardSize);
		myBoardView.start();

	}

	class NextRoundListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			playRound();
		}
	}

	class ResetGameListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			myBoard = new BoardModel(boardSize);
			myBoardView.updateView(convertCellArray(), boardSize);
			
		}
	}

	private void playRound() {
		if (!isGameOver()) {
			System.out.println("Round played!");
			nextRound();
			myBoardView.updateView(convertCellArray(), boardSize);
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
