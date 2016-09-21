package operations;

import computer.Memory;
import computer.ProgramCounter;

public class Jump extends Operation {
	private int i;

	public Jump(int i) {
		this.i = i;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		pc.setIndex(i - 1);
	}

	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("JMP " + new Integer(i).toString());
		return sb.toString();
	}
}
