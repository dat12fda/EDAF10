package operations;

import operands.Address;
import operands.Operand;
import operands.Word;
import computer.Memory;
import computer.ProgramCounter;

public class Add extends Expr {
	public Add(Operand first, Operand second, Operand adrs) {
		super(first, second, adrs);
		
	}

	protected void op(Operand first, Operand second, Memory memory) {
		Word word = first.getWord(memory);
		word.add(first, second, adrs, memory);
		
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ADD");
		sb.append(ifAddress(first) + ifAddress(second)
				+ ifAddress(adrs));
		return sb.toString();
	}

}