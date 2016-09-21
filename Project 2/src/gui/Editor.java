package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Slot;

public class Editor extends JTextField implements ActionListener, Observer {
	private Slot currentSlot;
    public Editor() {
        setBackground(Color.WHITE);
        addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
    	// activated by return key
    	// contents returned by getText()
    }

    public void setCurrent(Slot slot) {
    	//TODO
    }
    
    public void textToModel() {
    	//TODO
    }


	public void update(Observable o, Object arg) {
		// TODO 		
	}
}