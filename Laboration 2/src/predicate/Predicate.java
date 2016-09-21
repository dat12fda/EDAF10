package predicate;

import term.Term;
import term.TermList;
import term.Variable;

public class Predicate implements Expr {
	private String name;
	private TermList terms;

	public Predicate(String name, TermList terms) {
		this.name = name;
		this.terms = terms;
	}

	public String toString() {
		return name + terms;
	}

	@Override
	public Expr substitute(Variable variable, Term term) {
		TermList tl = new TermList();
		Term t;
		for (int i = 0; i < terms.size(); i++) {
			t = terms.get(i);
			tl.add(t.substitute(variable, term));
		}
		return new Predicate(name, tl);
	}

}
