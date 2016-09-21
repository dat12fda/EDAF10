package operations;

import computer.Address;
import computer.Memory;
import computer.Operand;
import computer.ProgramCounter;
import computer.Word;

public class Copy extends Operation {
	private Operand op;
	private Address ad;

	public Copy(Operand op, Address ad) {
		this.op = op;
		this.ad = ad;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		Word word = op.getWord(memory);
		memory.setData(ad.value(), word);
	}
	
	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("CPY ");
		sb.append(ifAddress(op, memory) + ifAddress(ad, memory));
		return sb.toString();
	}
}
