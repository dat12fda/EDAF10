package expr;
import java.util.Map;
import java.util.Set;


public class Equivalence extends extendedExpr {

	public Equivalence(Expr expr1, Expr expr2) {
		super(expr1, expr2);
	}	

	

	public boolean value(Map<Variable, Boolean> map) {
		return ((expr1.value(map)) == (expr2.value(map)));	
	}

	public String opString() {
		String s = (" <=> ");
		return s;
	}
}
