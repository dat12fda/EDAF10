package parser;

import java.io.Reader;
import java.io.StringReader;
import expr.And;
import expr.Expr;
import expr.Implies;
import expr.Not;
import expr.Or;
import expr.Variable;

public class Parser {
	private Scanner scanner;
	private int token;

	public Expr build(Reader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		if (token == Scanner.EOF) {
			return expr;
		} else {
			throw new ParserException("Trailing garbage after "
					+ scanner.token());
		}
	}

	public Expr build(String input) {
		return build(new StringReader(input));
	}

	private Expr expr() {
		Expr result, primary;
		result = primary();
		if (token == -3) {
			int op = token;
			token = scanner.nextToken();
			primary = primary();
			switch (op) {
			case -3:
				result = new Implies(result, primary);
				break;
			}
		}
		return result;
	}

	private Expr primary() {
		Expr result, term;
		result = term();
		while (token == '|') {
			int op = token;
			token = scanner.nextToken();
			term = term();
			switch (op) {
			case '|':
				result = new Or(result, term);
				break;
			}
		}
		return result;
	}

	private Expr term() {
		Expr result, factor;
		result = factor();
		while (token == '&') {
			int op = token;
			token = scanner.nextToken();
			factor = factor();
			switch (op) {
			case '&':
				result = new And(result, factor);
				break;
			}
		}
		return result;
	}

	private Expr factor() throws ParserException {
		Expr e;
		switch (token) {
		// factor
		case '!':
			token = scanner.nextToken();
			e = expr();
			token = scanner.nextToken();
			return new Not(e);			
			// Expr
	     case '(':
	    	   token = scanner.nextToken();
	    	   e = expr();
	    	   if (token == Scanner.EOF) {
	    	    throw new ParserException("Expecting \")\", found: EOF");
	    	   }
	    	   token = scanner.nextToken();
  	    	   return e;
		case -2:
			String s = scanner.token();
			token = scanner.nextToken();
			return new Variable(s);
		default:
			throw new ParserException("Unexpected " + scanner.token());			
		}		
	}
}