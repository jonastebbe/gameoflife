package de.gameoflife.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CellModelTest {

	@Test
	public void testCreation() {
		CellModel myCell = new CellModel(true);
		assertEquals(true, myCell.isAlive());
	}

}
