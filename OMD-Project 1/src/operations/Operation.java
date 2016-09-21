package operations;

import computer.Address;
import computer.Memory;
import computer.Operand;
import computer.ProgramCounter;
import computer.Word;

public abstract class Operation {

	protected abstract void run(Memory memory, ProgramCounter pc);

	public void execute(Memory memory, ProgramCounter pc) {
		run(memory, pc);
		int i = pc.getIndex();
		pc.setIndex(i + 1);
	}

	public abstract String toString(Memory memory);

	protected String ifAddress(Operand op, Memory memory) {
		String s;
		if (op instanceof Address) {
			Address ad = (Address) op;
			s = (" [" + ad.value() + "] ");
		} else {
			Word w = (Word) op;
			int i = (w.getWord(memory).value());
			s = " " + Integer.toString(i) + " ";
		}
		return s;
	}
}
