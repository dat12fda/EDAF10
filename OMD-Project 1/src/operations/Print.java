package operations;

import computer.Memory;
import computer.Operand;
import computer.ProgramCounter;

public class Print extends Operation {
	Operand op;

	public Print(Operand op) {

	}


	protected void run(Memory memory, ProgramCounter pc) {
		System.out.println(op.value());
	}
	
	
	public String toString(Memory memory) {
		StringBuilder sb = new StringBuilder();
		sb.append("PRT ");
		sb.append(ifAddress(op, memory));
		return sb.toString();
	}
	
}
