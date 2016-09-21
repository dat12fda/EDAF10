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
		Expr result, factor;
		result = primary();
		if (token == -3) {
			token = scanner.nextToken();
			factor = term();
			result = new Implies(result, factor);
		}
		return result;
	}

	private Expr primary() {
		Expr result, factor;
		result = term();
		while (token == '|') {
			token = scanner.nextToken();
			factor = term();
			result = new Or(result, factor);
		}
		return result;
	}

	private Expr term() {
		Expr result, factor;
		result = factor();
		while (token == '&') {
			token = scanner.nextToken();
			factor = factor();
			result = new And(result, factor);
		}
		return result;
	}

	private Expr factor() {
		Expr e;
		switch (token) {
		case '(':
			token = scanner.nextToken();
			e = expr();
			if(token == -1)
				throw new ParserException("Expecting \")\", found: EOF");
			token = scanner.nextToken();
			return e;
		case -2:
			String s = scanner.token();
			token = scanner.nextToken();
			return new Variable(s);
		case '!':
			token = scanner.nextToken();
			e = expr();
			token = scanner.nextToken();
			return new Not(e);
		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
	}
}