package computer;

public interface Operand {
	
	Word getWord(Memory mem);

	boolean equals(Operand second, Memory memory);
	
	public int value();
	
}
