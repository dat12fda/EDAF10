package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import controller.XLController;

public class Editor extends JTextField implements Observer {
    public Editor() {
        setBackground(Color.WHITE);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}