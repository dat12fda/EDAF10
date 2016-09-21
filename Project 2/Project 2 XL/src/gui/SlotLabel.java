package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Slot;

public class SlotLabel extends ColoredLabel {
	private Current current;
	private SlotLabel slotLabel = this;
	private int index;
	private String name;
	public SlotLabel(Current current, String s) {
		super("                    ", Color.WHITE, RIGHT);
		this.current = current;
		name = s;
		setBackground(Color.WHITE);
		addMouseListener(new ClickListener());
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getName(){
		return name;
	}

	private class ClickListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			current.setCurrent(slotLabel);
		}
	}
}