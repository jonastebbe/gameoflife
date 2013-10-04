package de.gameoflife.model;

public class Cell {

	private boolean isAlive;
	private boolean willBeAlive;
	
	public Cell(boolean isAlive) {
		super();
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void updateStatus() {
		isAlive = willBeAlive;
	}
	
	public void willBeDead() {
		willBeAlive = false;
	}
	
	public void willBeAlive() {
		willBeAlive = true;
	}
}
