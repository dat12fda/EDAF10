package computer;

public class Computer {
	private Memory memory;
	private Program prog;
	private ProgramCounter pc;

	public Computer(Memory memory) {
		this.memory = memory;
		pc = new ProgramCounter();
	}

	public void load(Program program) {
		this.prog = program;
	}

	public void run() {
		while (pc.getIndex() >= 0) {
			prog.get(pc.getIndex()).execute(memory, pc);
		
		}
	}
}
