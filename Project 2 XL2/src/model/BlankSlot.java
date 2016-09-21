package model;

import util.XLException;

public class BlankSlot implements Slot {
	public BlankSlot(){
		
	}
	public String toString() {
		return "";
	}
	
	public String value() {		
		throw new XLException("You may not link to a lonely beaver");	
	}
}
