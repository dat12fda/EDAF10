import java.util.Map;
import java.util.Set;

public class Negation extends Expr {
	private Expr expr;

	public Negation(Expr expr) {
		this.expr = expr;
	}

	protected void collectVariables(Set<Variable> set) {
		expr.collectVariables(set);
	}

	public boolean value(Map<Variable, Boolean> map) {
		if(expr.value(map))
			return false;
		return true;
	}

	
	public String toString() {
		String s = new String(expr.toString() + "'");
		return s;
	}
}
