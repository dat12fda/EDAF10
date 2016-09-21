package unknown;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnknownTest {

	@Test
    public void getShouldReturnPutObject() {
        Unknown unknown = new Unknown();
		unknown.put("First");
        Object o = "Second";
        unknown.put(o);
        assertSame(o, unknown.get());
    }

}
