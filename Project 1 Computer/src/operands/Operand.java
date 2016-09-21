package operands;

import computer.Memory;

public interface Operand {
	
	Word getWord(Memory memory);

	boolean compare(Operand second, Memory memory);
		
}
