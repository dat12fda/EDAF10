package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import expr.ExprParser;

public class SlotList extends Observable implements Observer {
	private List<Slot> slots;
	private CurrentSlot currentSlot;
	
	public SlotList(int size, ExprParser exprPars){
		this.slots = new ArrayList<Slot>();
		for(int i = 0; i < size; i++) {
			Slot current = new Slot("" , exprPars);
			slots.add(current);
			current.addObserver(this);
		}
	}
	
	public void set(Slot newSlot) {
		slots.set(currentSlot.counter(), newSlot);
	}
	
	
	public Slot get(int index){
		return slots.get(index);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
