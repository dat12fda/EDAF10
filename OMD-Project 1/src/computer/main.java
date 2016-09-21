package computer;

public class main {

	public static void main(String[] args) {
		Program factorial = new Factorial();
		System.out.println(factorial);
		Computer computer = new Computer(new LongMemory(64));
		computer.load(factorial);
		computer.run();
	}
}