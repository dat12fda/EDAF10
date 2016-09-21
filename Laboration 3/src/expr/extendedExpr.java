package expr;
import java.util.Map;
import java.util.Set;

public abstract class extendedExpr extends Expr {
	protected Expr expr1;
	protected Expr expr2;
	
	public extendedExpr(Expr expr1, Expr expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	protected void collectVariables(Set<Variable> set) {
		expr1.collectVariables(set);
		expr2.collectVariables(set);
	}

	public String toString() {
		String s = new String("(" + expr1.toString() + opString() + expr2.toString() + ")");
		return s;
	}

	
	public abstract String opString();

	public boolean value(Map<Variable, Boolean> map) {
		return value(map);
	}
}