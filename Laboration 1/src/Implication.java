import java.util.Map;
import java.util.Set;

public class Implication extends extendedExpr  {


	public Implication(Expr expr1, Expr expr2) {
		super(expr1, expr2);
	}

	

	public boolean value(Map<Variable, Boolean> map) {
		if (!  (  ((expr1.value(map)) == true)  && (expr2.value(map)) == false))    
			return true;
		return false;
	}

	public String opString() {
		String s = (" => ");
		return s;
	}
}
