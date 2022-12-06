package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator calc;
	int result;
	
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
	
	@Test
    void testAddManyNumbers() {
    	int result = calc.Add("1,2,3,4,5");
        assertEquals(15, result);
    }
	
	@Test
	void testAddNewLines() {
		int result = calc.Add("1\n2,3");
		assertEquals(6, result);
	}
}
