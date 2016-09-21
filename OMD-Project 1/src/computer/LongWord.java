package computer;

public class LongWord extends Word {
	private long word;

	public LongWord(long word) {
		this.word = word;
	}

	public void add(Operand first, Operand second, Address adrs, Memory mem) {
		word = (long) ((first.getWord(mem).value() + second.getWord(mem)
				.value()));
		mem.setData(adrs.value(), new LongWord(word));
		
	}

	public void mul(Operand first, Operand second, Address adrs, Memory mem) {
		word = (long) ((first.getWord(mem).value() * second.getWord(mem)
				.value()));
		mem.setData(adrs.value(), new LongWord(word));

	}

	public int value() {
		return (int) word;
	}

	public Word getWord(Memory mem) {
		return this;
	}
	
	public boolean equals(Operand operand, Memory memory) {
		if (this.word == operand.getWord(memory).value() ) {
			return true;
		}
		return false;
		
	}

}
