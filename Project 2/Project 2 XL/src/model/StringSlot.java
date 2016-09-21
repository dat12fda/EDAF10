package model;

public class StringSlot implements Slot {
	private String comment;

	public StringSlot(String comment) {
		this.comment = comment;
	}

	public String toString() {
		return comment;
	}
}