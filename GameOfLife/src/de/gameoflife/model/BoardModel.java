package de.gameoflife.model;

import java.util.Random;

public class BoardModel {

	Random randomizer = new Random();

	private CellModel[][] cells;
	private int boardSize;

	public BoardModel() {
		new BoardModel(boardSize);
	}

	public BoardModel(int boardSize) {
		cells = new CellModel[boardSize][boardSize];
		this.boardSize = boardSize;
		populate();
	}

	public BoardModel(int boardSize, CellModel[][] cells) {
		this.cells = cells;
		this.boardSize = boardSize;
	}

	private void populate() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {

				cells[i][j] = new CellModel(randomizer.nextBoolean());
			}
		}
	}

	public CellModel[][] getCells() {
		return cells;
	}

	public int getBoardSize() {
		return boardSize;
	}

	private void cellSurvives(int x, int y) {
		int livingNeighbors = countLivingNeighbors(x, y);

		if (livingNeighbors == 2 || livingNeighbors == 3) {
			cells[x][y].willBeAlive();
		} else {
			cells[x][y].willBeDead();
		}
	}

	private void cellRevives(int x, int y) {
		int livingNeighbours = countLivingNeighbors(x, y);

		if (livingNeighbours == 3) {
			cells[x][y].willBeAlive();
		} else {
			cells[x][y].willBeDead();
		}
	}

	public void determineStatusForNextRound(int i, int j) {
		if (cells[i][j].isAlive()) {
			cellSurvives(i, j);
		} else {
			cellRevives(i, j);
		}
	};

	public void updateStatus(int x, int y) {
		cells[x][y].updateStatus();
	}

	private int countLivingNeighbors(int x, int y) {
		int numberOfLivingNeighbors = 0;
		int minX = x - 1;
		int minY = y - 1;
		int maxX = x + 1;
		int maxY = y + 1;

		if (x == 0) {
			minX = x;
		} else if (x == (boardSize - 1)) {
			maxX = x;
		}

		if (y == 0) {
			minY = y;
		} else if (y == (boardSize - 1)) {
			maxY = y;
		}

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (!(i == x && j == y)) {
					if (cells[i][j].isAlive()) {
						numberOfLivingNeighbors++;
					}
				}
			}
		}

		return numberOfLivingNeighbors;
	}

	public boolean getStatus(int x, int y) {
		return cells[x][y].isAlive();
	}

	public int numberOfLivingCells() {
		int numberOfLivingCells = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (cells[i][j].isAlive()) {
					numberOfLivingCells++;
				}
			}
		}
		return numberOfLivingCells;
	}
}