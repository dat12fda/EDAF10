package operations;

import computer.Address;
import computer.Memory;
import computer.Operand;
import computer.Word;

public class Add extends Expr {
	public Add(Operand first, Operand second, Address adrs) {
		super(first, second, adrs);
		
	}

	protected void op(Operand first, Operand second, Memory memory) {
		Word word = first.getWord(memory);
		word.add(first, second, adrs, memory);
	}

	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("ADD ");
		sb.append(ifAddress(first, memory) + ifAddress(second, memory)
				+ ifAddress(adrs, memory));
		return sb.toString();
	}

}