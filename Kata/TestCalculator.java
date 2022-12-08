package Kata;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

class TestCalculator {
	@BeforeEach
	void setUp() throws Exception {
		new Calculator();
	}

	@Test
    public void ZeroForAnEmptyString() throws Exception {
        assertEquals(Calculator.Add(""),0);
    }
	
	@Test
	public void StringWithOneNumber() throws Exception {
		assertEquals(Calculator.Add("7"), 7);
	}
	
	@Test
	public void StringWithNegativeNumber() throws Exception{
		Throwable exception = assertThrows(Exception.class, () -> {
			   Calculator.Add("-7");
			  });
		assertEquals(exception.getMessage(), "negatives not allowed: -7");
	}
	
	@Test
	public void StringWithCommaSeparatedNumbers() throws Exception {
		assertEquals(Calculator.Add("3,4"), 7);
	}
	
	@Test
	public void StringWithManyCommaSeparatedNumbers() throws Exception {
		assertEquals(Calculator.Add("1,1,2,3"), 7);
	}
	@Test 
	public void StringWithNumberMoreThan1000() throws Exception {
		assertEquals(Calculator.Add("7,1001"), 7);
	}
	
	@Test
	public void StringWithNewLinesAsNumberDelimiter() throws Exception {
		assertEquals(Calculator.Add("1\\,1\n2,3\n"), 7);
	}
	
	@Test
	public void StringWithDifferentDelimitersTest() throws Exception
	{
		assertEquals(Calculator.Add("//[1*]1[%]\\n*2%3;0"), 7);
	}
}
