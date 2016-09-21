package model;

import expr.Expr;
import expr.Variable;

public class CommentSlot implements Slot {
	private String comment;

	public CommentSlot(String comment) {
		this.comment = comment;
	}

	public String toString() {
		return comment;
	}

	public String value() {
		return "0";
	}
}