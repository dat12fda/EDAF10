import java.util.Map;
import java.util.Set;

public class Conjunction extends extendedExpr  { // And


	public Conjunction(Expr expr1, Expr expr2) {
		super(expr1, expr2);
	}

	

	public boolean value(Map<Variable, Boolean> map) {
		return (expr1.value(map) && expr2.value(map));
		
	}

		public String opString() {
			String s = (" and ");
			return s;
		}

}
