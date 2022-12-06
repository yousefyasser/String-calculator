package StringCalculatorKata;

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
    	result = calc.Add("");
        assertEquals(0, result);
    }
	
	@Test
    void testAddOneNumber() {
    	result = calc.Add("1");
        assertEquals(1, result);
    }
	
	@Test
    void testAddTwoNumbers() {
    	result = calc.Add("1,2");
        assertEquals(3, result);
    }
	
	@Test
    void testAddManyNumbers() {
    	result = calc.Add("1,2,3,4,5");
        assertEquals(15, result);
    }
	
	@Test
	void testAddNewLines() {
		result = calc.Add("1\n2,3");
		assertEquals(6, result);
	}
	
	@Test
	void testDifferentDelimiters() {
		result = calc.Add("//;\n1;2");
		assertEquals(3, result);
	}
}
