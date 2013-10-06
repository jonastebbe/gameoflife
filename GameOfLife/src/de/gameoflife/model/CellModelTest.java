package de.gameoflife.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellModelTest {

	private CellModel cell;
	
	@Test
	public void testCellIsAlive() {
		cell = new CellModel(true);
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void testCellIsDead() {
		cell = new CellModel(false);
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void testCellWillDie() {
		cell = new CellModel(true);
		cell.willBeDead();
		cell.updateStatus();
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void testCellStayDead() {
		cell = new CellModel(false);
		cell.willBeDead();
		cell.updateStatus();
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void testCellBeBorn() {
		cell = new CellModel(false);
		cell.willBeAlive();
		cell.updateStatus();
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void testCellStayAlive() {
		cell = new CellModel(true);
		cell.willBeAlive();
		cell.updateStatus();
		assertTrue(cell.isAlive());
	}


}
