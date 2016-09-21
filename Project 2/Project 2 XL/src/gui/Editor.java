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

	public Editor(SlotList slotList, StatusLabel statusLabel) {
		this.slotList = slotList;
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		addActionListener(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof SlotLabel)
			currentSlot = (SlotLabel) arg1;
		setText(slotList.getText(currentSlot.getName()));
	}

	public void actionPerformed(ActionEvent event) {
		StringBuilder sb = new StringBuilder();
		sb.append(currentSlot.getName());
		sb.append("=");
		sb.append(getText());
		try {			
			try {
				currentSlot.setText(slotList.input(sb.toString()));
			} catch (XLException e) {
				statusLabel.setText(e.toString());
			}
		} catch (NoSuchElementException e) {
			statusLabel.setText(e.toString());
		}
	}
}