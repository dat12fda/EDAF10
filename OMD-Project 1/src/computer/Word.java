package computer;

public abstract class Word implements Operand {
	public Word() {		
	}

	public abstract void add(Operand first, Operand second, Address adrs, Memory mem);

	public abstract void mul(Operand first, Operand second, Address adrs, Memory mem);

	public abstract Word getWord(Memory mem);

	public abstract int value();
	
	public abstract boolean equals(Operand operand, Memory memory);
		
	

}
