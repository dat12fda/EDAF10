package gui;

import java.awt.Color;
import java.util.NoSuchElementException;
import java.util.Observable;

import model.Slot;
import model.SlotList;

public class Current extends Observable {
	private String currentName;
	
	public Current() {
		currentName = "A1";
		}

	public void setCurrent(String name) {	
		currentName = name;
		setChanged();
		notifyObservers(name);
	}
	
	public String getName() {
		return currentName;
	}
}
