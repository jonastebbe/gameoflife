package de.gameoflife.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellModelTest {

	private CellModel cell;
	
	@Test
	public void shouldBeAlive() {
		//assume
		cell = new CellModel(true);
		//then
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void shouldBeDead() {
		//assume
		cell = new CellModel(false);
		//then
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void shouldDie() {
		//assume
		cell = new CellModel(true);
		//given
		cell.willBeDead();
		//when
		cell.updateStatus();
		//then
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void shouldStayDead() {
		//assume
		cell = new CellModel(false);
		//given
		cell.willBeDead();
		//when
		cell.updateStatus();
		//then
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void shouldBeBorn() {
		//assume
		cell = new CellModel(false);
		//given
		cell.willBeAlive();
		//when
		cell.updateStatus();
		//then
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void shouldStayAlive() {
		//assume
		cell = new CellModel(true);
		//given
		cell.willBeAlive();
		//when
		cell.updateStatus();
		//then
		assertTrue(cell.isAlive());
	}


}
