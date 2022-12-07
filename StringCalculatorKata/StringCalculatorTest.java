package StringCalculatorKata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator calc;
	int result;
	
	@BeforeEach
	void setUp(){
		calc = new StringCalculator();
	}

	@Test
    void testAddEmptyString() throws Exception{
    	result = calc.Add("");
        assertEquals(0, result);
    }
	
	@Test
    void testAddOneNumber() throws Exception{
    	result = calc.Add("1");
        assertEquals(1, result);
    }
	
	@Test
    void testAddTwoNumbers() throws Exception{
    	result = calc.Add("1,2");
        assertEquals(3, result);
    }
	
	@Test
    void testAddManyNumbers() throws Exception{
    	result = calc.Add("1,2,3,4,5");
        assertEquals(15, result);
    }
	
	@Test
	void testAddNewLines() throws Exception{
		result = calc.Add("1\n2,3");
		assertEquals(6, result);
	}
	
	@Test
	void testDifferentDelimiters() throws Exception {
		result = calc.Add("//;\n1;2");
		assertEquals(3, result);
	}
	
	@Test
	void testAddWithNegativeNumbers() throws Exception{
		Throwable exception = assertThrows(Exception.class, () -> {
			   calc.Add("-1,-2,3");
			  });
		
		assertEquals("negatives not allowed: -1 -2", exception.getMessage());
	}
	
	@Test
	void testAddNumbersBiggerThan1000() throws Exception{
		result = calc.Add("2,1001");
		assertEquals(2, result);
	}
	
	@Test
	void testDelimitersOfUnknownLength() throws Exception{
		result = calc.Add("//[**]\n1**2**3");
		assertEquals(6, result);
	}
}
