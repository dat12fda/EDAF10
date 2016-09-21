package operations;

import computer.Memory;
import computer.Operand;
import computer.ProgramCounter;

public class JumpEq extends Operation {
	private Operand first, second;
	private int i;

	public JumpEq(int i, Operand first, Operand second) {
		this.first = first;
		this.second = second;
		this.i = i;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		if (first.equals(second, memory)) {
			pc.setIndex(i - 1);
		}
	}

	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("JEQ ");
		sb.append(ifAddress(first, memory) + ifAddress(second, memory)
				+ new Integer(i).toString());
		return sb.toString();
	}
}
