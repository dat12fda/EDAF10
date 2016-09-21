package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
	public CurrentLabel() {
		super("A1", Color.WHITE);
	}

	public void update(Observable o, Object arg) {		
		if (arg instanceof SlotLabel)
			setText(((SlotLabel) arg).getName());	
	}
}