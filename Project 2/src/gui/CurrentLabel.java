package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

	public void update(Observable o, Object arg) {
		// TODO  		
	}    
}