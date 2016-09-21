package term;

import java.util.Set;

public class Function implements Term {
	private String name;
	private TermList list;

	public Function(String name, TermList list) {
		this.name = name;
		this.list = list;
	}

	public Set<Variable> collectVariables(Set<Variable> set) {
		return list.collectVariables(set);
	}

	public String toString() {
		return name + list;
	}
	
	public boolean containsVariable(Variable variable) {
		if(list.contains(variable)) 
			return true;
		return false;
	}

	public Term substitute(Variable x, Term term) {
		TermList tl = new TermList();
		Term t;
		for (Term temp : list) {
			t = temp.substitute(x, term);
			tl.add(t);
		}
		return new Function(name, tl);
	}
}
