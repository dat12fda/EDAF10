package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

import util.XLException;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class SlotList implements Environment {
	private HashMap<String, Slot> slotList;
	private ExprParser exprParser = new ExprParser();

	public SlotList() {
		slotList = new HashMap<String, Slot>();
		for (int row = 1; row <= 10; row++) {
			for (char ch = 'A'; ch < 'A' + 8; ch++) {
				StringBuilder sb = new StringBuilder();
				sb.append(ch);
				sb.append(row);
				slotList.put(sb.toString(), new StringSlot(""));
			}
		}
	}

	public Slot get(int i) {
		return slotList.get(i);
	}

	/**
	 * Puts in the input into a slot and saves it as a comment or an expression.
	 * @param entry The slot input, starting with the slot name followed by '='	 
	 * @return String representation of the value after calculating input
	 */
	public String input(String entry) {
		StringBuilder sb = new StringBuilder();
		StringBuilder key = new StringBuilder();
		Slot slot;
		sb.append(entry);
		key.append(sb.charAt(0));
		key.append(sb.charAt(1));
		if(sb.charAt(2) == '0'){
			key.append(sb.charAt(2));
			sb.delete(0, 4);
		} else {
		sb.delete(0, 3);				
		}
		String index = key.toString();
		if (sb.charAt(0) == '#') {
			String comment = sb.toString();
			slot = new StringSlot(comment);
			slotList.remove(index);
			slotList.put(index, slot);
			sb.delete(0, 1);
			return sb.toString();
		} else {
			Slot temp = slotList.get(index);
			slotList.put(index, new BombSlot());
			try {
				Expr expr = exprParser.build(sb.toString());
				slot = new ExprSlot(expr);
				double i = expr.value(this);
				slotList.remove(index);
				slotList.put(index, slot);
				return Double.toString(i);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			slotList.put(index, temp);
		}
		return "";
	}

	public String getText(String name) {
		return slotList.get(name).toString();
	}

	public double value(String name) {
		double i = 0;
		Slot slot;
		try {
			if (slotList.containsKey(name)) {
				slot = slotList.get(name);
				Expr expr = exprParser.build(slot.toString());
				i = expr.value(this);
				return i;
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}
}
