package controller;

import gui.XL;

import java.util.Observable;
import java.util.Observer;

import model.SlotList;

public class XLController extends Observable implements Observer {
	XL xl;
	SlotList slotList;

	public XLController(XL xl, SlotList slotList) {
		this.xl = xl;
		this.slotList = slotList;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		notifyObservers();
		System.out.println("test");
	}
}
