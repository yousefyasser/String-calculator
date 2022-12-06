package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator calc;
	
	@BeforeEach
	void setUp() throws Exception {
		calc = new StringCalculator();
	}

	@Test
    void testAddEmptyString() {
    	int result = calc.Add("");
        assertEquals(0, result);
    }
	
}
