package de.gameoflife.controller;

import de.gameoflife.model.BoardModel;
import de.gameoflife.view.BoardView;

public class BoardController {

	BoardModel myBoard = new BoardModel(10);
	BoardView myBoardView = new BoardView(myBoard.getBoardSize());
	
	public BoardController() {
		myBoardView.setBoardController(this);
		startGame();

	}

	private void startGame() {
		int c = 1;
		while (!isGameOver()) {
			System.out.println("Round: " + c + "\n");
			updateView();
			nextRound();
			c++;
		}
	};

	private void updateView() {
		for (int i = 0; i < myBoard.getBoardSize(); i++) {
			for (int j = 0; j < myBoard.getBoardSize(); j++) {
				// iterate through labels
				// board.getStatus(i, j);
			}
		}
	};

	public void nextRound() {
		for (int i = 0; i < myBoard.getBoardSize(); i++) {
			for (int j = 0; j < myBoard.getBoardSize(); j++) {
				myBoard.statusInNextRound(i, j);
			}
		}
		for (int i = 0; i < myBoard.getBoardSize(); i++) {
			for (int j = 0; j < myBoard.getBoardSize(); j++) {
				myBoard.updateStatus(i, j);
			}
		}
	}

	private boolean isGameOver() {
		return 0 == myBoard.numberOfLivingCells();
	}

}
