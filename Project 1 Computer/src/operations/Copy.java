package operations;

import operands.Address;
import operands.LongWord;
import operands.Operand;
import operands.Word;
import computer.Memory;
import computer.ProgramCounter;

public class Copy extends Operation {
	private Operand op;
	private Address ad;

	public Copy(Operand op, Address ad) {
		this.op = op;
		this.ad = ad;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		Word word = op.getWord(memory);
		new Add(word, new LongWord(0),ad);
		pc.incrementCounter();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CPY" + ifAddress(op) + ifAddress(ad));
		return sb.toString();
	}
}
