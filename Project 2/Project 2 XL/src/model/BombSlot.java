package model;

import java.io.IOException;
import java.util.NoSuchElementException;

public class BombSlot implements Slot {
	public BombSlot() {		
	}
	
	public String toString(){		
		throw new NoSuchElementException("You may not link a slot to slots containing said slot");		
		}
	}
	

