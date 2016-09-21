package predicate;

import java.util.HashSet;

import term.Function;
import term.Term;
import term.Variable;

public class ForAll implements Expr {
	private Variable x;
	private Expr px;

	public ForAll(Variable x, Expr px) {
		this.x = x;
		this.px = px;
	}

	public String toString() {
		return "ForAll" + x + "." + px;
	}

	@Override
	public Expr substitute(Variable variable, Term term) {
		if (variable.equals(x))
			return this;
		HashSet<Variable> s = new HashSet<Variable>();
		term.collectVariables(s);
		if (s.contains(x)) {
			Variable v = new Variable();
			Expr sub = px.substitute(x, v);
			return new ForAll(v, sub.substitute(variable, term));
	
		}
		return new ForAll(x, px.substitute(variable, term));
	}

}
