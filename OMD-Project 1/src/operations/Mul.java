package operations;

import computer.Address;
import computer.Memory;
import computer.Operand;
import computer.Word;

public class Mul extends Expr {
	public Mul(Operand first, Operand second, Address adrs) {
		super(first, second, adrs);
	}

	protected void op(Operand first, Operand second, Memory memory) {
		Word word = first.getWord(memory);
		word.mul(first, second, adrs, memory);		
	}
	
	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("MUL ");
		sb.append(ifAddress(first, memory) + ifAddress(second, memory)
				+ ifAddress(adrs, memory));
		return sb.toString();
	}
}