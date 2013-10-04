package de.gameoflife.controller;

import de.gameoflife.model.Board;

public class BoardController {

	public static void main(String[] args) {
		Board myBoard = new Board(10);
		startGame(myBoard);
	}

	private static void startGame(Board board) {
		while (!isGameOver(board)) {
			updateView(board);
			nextRound(board);
		}
	};
	
	private static void updateView(Board board) {
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				// iterate through labels
				// board.getStatus(i, j);
			}
		}
	};

	private static void nextRound(Board board) {
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				board.statusInNextRound(i, j);
			}
		}
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				board.updateStatus(i, j);
			}
		}
	}
	
	private static boolean isGameOver(Board board) {
		return 0 == board.numberOfLivingCells(); 
	}
	
}
