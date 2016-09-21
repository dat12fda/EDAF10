package predicate;

import term.Term;
import term.Variable;

public class Implies implements Expr {
	private Expr px;
	private Expr py;

	public Implies(Expr px, Expr py) {
		this.px = px;
		this.py = py;
	}

	public String toString() {
		return "(" + px + "->" + px + ")";
	}

	public Expr substitute(Variable variable, Term term) {
		return new Implies(px.substitute(variable, term), py.substitute(variable, term));
	}

}
