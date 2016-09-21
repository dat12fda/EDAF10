package operands;

import computer.Memory;

public abstract class Word implements Operand {
	public Word() {	
		
	}

	public abstract void add(Operand first, Operand second, Operand adrs, Memory memory);

	public abstract void mul(Operand first, Operand second, Operand adrs, Memory memory);

	public abstract Word getWord(Memory mem);

	public abstract long value();
	
	public abstract boolean compare(Operand operand, Memory memory);
		
	

}
