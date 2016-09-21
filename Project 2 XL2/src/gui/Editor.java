package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import util.XLException;

import model.Slot;
import model.SlotList;

public class Editor extends JTextField implements Observer, ActionListener {
	private SlotLabel currentSlot;
	private SlotList slotList;
	private StatusLabel statusLabel;
	private XL xl;

	public Editor(SlotList slotList, StatusLabel statusLabel, XL xl) {
		this.xl = xl;
		this.slotList = slotList;
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		addActionListener(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof SlotLabel)
			currentSlot = (SlotLabel) arg1;
		try {
			setText(slotList.getText(currentSlot.getName()));
		}
		catch (XLException ex) {
			statusLabel.setText(ex.toString());
		}
		
	}

	public void actionPerformed(ActionEvent event) {

		try {
			currentSlot
					.setText(slotList.input(getText(), currentSlot.getName()));
			xl.updateLabels();
		} catch (XLException e) {
			statusLabel.setText(e.toString());
		}
	}

	public void clearSlot() {
		slotList.input("", currentSlot.getName());
		setText("");
	}
}