package controller;

import gui.XL;

import java.util.Observable;
import java.util.Observer;

import model.SlotList;

public class XLController extends Observable implements Observer {
	
	public XLController(XL xl, SlotList slotList) {
		addObserver(xl);
		addObserver(slotList);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		notifyObservers();
	}
}
