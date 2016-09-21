package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import util.XLException;
import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class SlotList implements Environment {
	private HashMap<String, Slot> slotList;
	private ExprParser exprParser = new ExprParser();

	public SlotList() {
		clear();
	}

	public Slot get(int i) {
		return slotList.get(i);
	}

	public HashMap<String, Slot> getHashMap() {
		return slotList;
	}

	/**
	 * Puts in the input into a slot and saves it as a comment or an expression.
	 * 
	 * @param entry
	 *            The slot input, starting with the slot name followed by '='
	 * @return String representation of the value after calculating input
	 */

	public void checkDependencies(String expr) {
		Collection<Slot> set = slotList.values();
		String temp;
		Slot slot;
		java.util.Iterator<Slot> it = set.iterator();
		while (it.hasNext()) {
			slot = it.next();
			if (!(slot instanceof BlankSlot)) {
				temp = slot.value();
				if (temp.contains(expr)) {
					throw new XLException("Dependency error");
				}
			}
		}
	}

	public String input(String entry, String key) {
		StringBuilder sb = new StringBuilder();
		sb.append(entry);
		Slot slot;
		if (sb.length() == 0) {
			checkDependencies(key);
			slotList.remove(key);
			slotList.put(key, new BlankSlot());
			return "";
		}
		if (sb.charAt(0) == '#') {
			String comment = sb.toString();
			slot = new CommentSlot(comment);
			slotList.remove(key);
			slotList.put(key, slot);
			sb.delete(0, 1);
			return sb.toString();
		} else {
			Slot temp = slotList.get(key);
			slotList.put(key, new BombSlot());
			try {
				Expr expr = exprParser.build(sb.toString());
				slot = new ExprSlot(expr);
				double i = expr.value(this);
				slotList.remove(key);
				slotList.put(key, slot);
				return Double.toString(i);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			slotList.remove(key);
			slotList.put(key, temp);
		}
		return "";
	}

	public double value(String name) {
		double i = 0;
		Slot slot;
		try {
			if (slotList.containsKey(name)) {
				StringBuilder sb = new StringBuilder();
				slot = slotList.get(name);
				sb.append(slot.toString());
				Expr expr = exprParser.build(slot.value());
				i = expr.value(this);
				return i;
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	public String getText(String name) {
		return slotList.get(name).toString();
	}

	public void clear() {
		slotList = new HashMap<String, Slot>();
		for (int row = 1; row <= 10; row++) {
			for (char ch = 'A'; ch < 'A' + 8; ch++) {
				StringBuilder sb = new StringBuilder();
				sb.append(ch);
				sb.append(row);
				slotList.put(sb.toString(), new BlankSlot());
			}
		}
	}
}
