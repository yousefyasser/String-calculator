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
	
	@Test
    void testAddOneNumber() {
    	int result = calc.Add("1");
        assertEquals(1, result);
    }
	
	@Test
    void testAddTwoNumbers() {
    	int result = calc.Add("1,2");
        assertEquals(3, result);
    }
	
}
