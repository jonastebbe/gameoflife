package de.gameoflife.view;

public class BoardViewConsole implements BoardView {
	
	@Override
	public void updateView(boolean[][] cells, int boardSize) {
		System.out.println("---------------------------------------------------");
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (cells[i][j]) {
					System.out.print("o ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		System.out.println("---------------------------------------------------\n");
	}

}
