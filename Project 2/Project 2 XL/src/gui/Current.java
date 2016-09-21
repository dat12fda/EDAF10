package gui;

import java.awt.Color;
import java.util.NoSuchElementException;
import java.util.Observable;

import model.Slot;

public class Current extends Observable {
	private SlotLabel currentSlot;

	public Current(Editor editor, CurrentLabel currentLabel) {
		currentSlot = new SlotLabel(this, "A1");
		addObserver(editor);
		addObserver(currentLabel);		
	}

	public void setCurrent(SlotLabel slot) {
		currentSlot.setBackground(Color.WHITE);
		currentSlot = slot;
		currentSlot.setBackground(Color.YELLOW);
		setChanged();
		notifyObservers(slot);
	}
}
