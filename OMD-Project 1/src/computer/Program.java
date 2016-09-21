package computer;

import java.util.ArrayList;
import java.util.List;

import operations.Operation;

public class Program extends ArrayList<Operation> {
	private List<Operation> op;
	private int pos = 0;
	private StringBuilder sb = new StringBuilder();

	public Program() {
		this.op = new ArrayList<Operation>();

	}

	public void changePos(int n) {
		pos = n;
	}

	public int getPos() {
		return pos;
	}

	public String toString() {

		for (int i = 0; i < op.size(); i++) {
			sb.append(i);
			sb.append(op.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
