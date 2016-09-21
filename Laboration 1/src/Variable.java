import java.util.Map;
import java.util.Set;

public class Variable extends Expr {
	private String name;
	private int hashCode;

	public Variable(String name) {
		this.name = name;
		hashCode = name.hashCode();
	}

	public int hashCode() {
		return hashCode;
	}

	protected void collectVariables(Set<Variable> set) {
		if (!set.contains(this))
			set.add(this);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object obj) {
		if(hashCode() == obj.hashCode())
			return true;
		return false;		
	}

	public boolean value(Map<Variable, Boolean> map) {
		return map.get(this);
	}
}
