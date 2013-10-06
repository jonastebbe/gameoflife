package de.gameoflife.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardModelTest {
	
	private BoardModel board;
	private CellModel[][] cells = new CellModel[3][3];

	@Test
	public void shouldHaveSameBoardSizeAsInitialized() {
		//assume
		board = new BoardModel(3, cells);
		//then
		assertTrue(board.getBoardSize() == 3);
	}
	
	@Test
	public void shouldDieDueToOverpopulation() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(true);
		cells[1][0] = new CellModel(true);
		cells[1][1] = new CellModel(true);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertFalse(board.getStatus(1,1));
	}
	
	@Test
	public void shouldDieDueToUnderpopulation() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(false);
		cells[0][2] = new CellModel(false);
		cells[1][0] = new CellModel(false);
		cells[1][1] = new CellModel(true);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertFalse(board.getStatus(1,1));
	}
	
	@Test
	public void shouldStayDeadDueToUnderpopulation() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(false);
		cells[1][0] = new CellModel(false);
		cells[1][1] = new CellModel(false);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertFalse(board.getStatus(1,1));
	}

	@Test
	public void shouldStayDeadDueToOverpopulation() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(true);
		cells[1][0] = new CellModel(true);
		cells[1][1] = new CellModel(false);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertFalse(board.getStatus(1,1));
	}
	
	@Test
	public void shouldStayAliveWithTwoNeighbors() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(false);
		cells[1][0] = new CellModel(false);
		cells[1][1] = new CellModel(true);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertTrue(board.getStatus(1,1));
	}
	
	@Test
	public void shouldStayAliveWithThreeNeighbors() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(true);
		cells[1][0] = new CellModel(false);
		cells[1][1] = new CellModel(true);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertTrue(board.getStatus(1,1));
	}

	@Test
	public void shouldReviveWithThreeNeighbors() {
		//assume
		cells[0][0] = new CellModel(true);
		cells[0][1] = new CellModel(true);
		cells[0][2] = new CellModel(true);
		cells[1][0] = new CellModel(false);
		cells[1][1] = new CellModel(false);
		cells[1][2] = new CellModel(false);
		cells[2][0] = new CellModel(false);
		cells[2][1] = new CellModel(false);
		cells[2][2] = new CellModel(false);		
		board = new BoardModel(3, cells);
		//give
		board.determineStatusForNextRound(1,1);
		//when
		board.updateStatus(1,1);
		//then
		assertTrue(board.getStatus(1,1));
	}

	
}
