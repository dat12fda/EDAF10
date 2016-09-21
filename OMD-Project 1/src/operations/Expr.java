package operations;

import computer.Address;
import computer.Memory;
import computer.Operand;
import computer.ProgramCounter;

public abstract class Expr extends Operation {
	protected Operand first, second;
	protected Address adrs;

	protected Expr(Operand first, Operand second, Address adrs) {
		this.first = first;
		this.second = second;
		this.adrs = adrs;
	}

	protected void run(Memory memory, ProgramCounter pc) {
		op(first, second, memory);
	}

	protected abstract void op(Operand op1, Operand op2, Memory memory);
}
