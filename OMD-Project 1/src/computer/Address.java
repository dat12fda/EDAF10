package computer;

public class Address implements Operand {
	private int n;

	public Address(int n) {
		this.n = n;
	}

	public int value() {
		return n;
	}

	public void setWord(Memory mem, Word w) {
		mem.setData(n, w);
	}

	public Word getWord(Memory mem) {
		return mem.getWord(n);
	}
	
	public boolean equals(Operand operand, Memory memory) {
		return getWord(memory).equals(operand.getWord(memory));
	}

}
