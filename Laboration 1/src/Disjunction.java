import java.util.Map;
import java.util.Set;

public class Disjunction extends extendedExpr  { // Or


	public Disjunction(Expr expr1, Expr expr2) {
		super(expr1, expr2);
	}
	
	

	public boolean value(Map<Variable, Boolean> map) {
		if (expr1.value(map) || expr2.value(map))
			return true;
		else {
			return false;
		}
	}

	public String opString() {
		String s = (" or ");
		return s;
	}
}
