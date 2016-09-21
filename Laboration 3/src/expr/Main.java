package expr;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {
		boolean exists = true;
		boolean notThere = false;
		Variable var1 = new Variable("B");
		Variable var2 = new Variable("E");
		Map<Variable, Boolean> map = new HashMap<Variable, Boolean>();
		map.put(new Variable("A"), exists);
		map.put(var1, exists);
		map.put(new Variable("C"), exists);
		map.put(new Variable("D"), notThere);
		map.put(var2, notThere);
		map.put(new Variable("F"), notThere);

		And hej = new And(new Variable("A"), new Variable("D"));
		And hej2 = new And(var1, var2);

		Not neg = new Not(var1);
		Or hej3 = new Or(var1, neg);
		Implies hej4 = new Implies(hej3, hej2);
		And hej5 = new And(hej4, hej);
		
		if (hej3.isTautology())
			System.out.println(hej3.toString() + " är Tautologi");
		else {
			System.out.println(hej3.toString() + " fungerar ej");
		}
		
		if (hej4.isTautology())
			System.out.println(hej4.toString() + " är Tautologi");
		else {
			System.out.println(hej4.toString() + " fungerar ej");
		}


		if (!(hej.value(map)))
			System.out.println(hej2.toString() + " fungerar");
		else {
			System.out.println(hej2.toString() + " fungerar ej");
		}

		if (!(hej2.value(map)))
			System.out.println(hej2.toString() + " fungerar");
		else {
			System.out.println(hej2.toString() + " fungerar ej");
		}
		
		if (!(hej5.value(map)))
			System.out.println(hej5.toString() + " fungerar");
		else {
			System.out.println(hej5.toString() + " fungerar ej");
		}

	}
}
