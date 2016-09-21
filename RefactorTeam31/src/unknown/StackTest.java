package unknown;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructures.Stack;
import datastructures.SuperStack2;

public class StackTest {

	private SuperStack2 lifo;
	private Object second;
	private Object third;

	@Test
	public void getShouldReturnPutObject() {
		lifo.push(second, 7);
		assertSame(second, lifo.pop());
	}

	@Before
	public void setUp() {
		second = "Second";
		third = "Third";
		lifo = new Stack();
		lifo.push("First", 7);
	}

	@Test
	public void testMultiple() {
		lifo.push(second, 7);
		lifo.push(third, 7);
		assertSame("Objects aren't returned in LIFO order", third, lifo.pop());
		assertSame("Objects aren't returned in LIFO order", second, lifo.pop());
	}
	
	public void aMethod(){
    	SuperStack2 s = new Stack();
    	hej(s);
    	s.push(5, 7);
    	Object result = result(s);
    	s.push(result, 7);
    	}

	public Object result(SuperStack2 s) {
		Object result = s.pop();
		return result;
	}

	public void hej(SuperStack2 s) {
		s.push(3, 7);
    	s.push(4, 7);
	}
}
