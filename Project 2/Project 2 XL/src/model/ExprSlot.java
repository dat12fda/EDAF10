package model;

import expr.Expr;

public class ExprSlot implements Slot {
	private Expr expr;
	public ExprSlot(Expr expr){
		this.expr = expr;
	}
	
	public String toString() {
		return expr.toString();
	}
}
