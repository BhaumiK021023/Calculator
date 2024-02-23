package example.incubye;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test_1() {
		String numbers="1,2,3,4";
		Assertions.assertEquals(10, Calculator.add(numbers));
	}
	@Test
	void test_2() {
		String numbers="";
		Assertions.assertEquals(0, Calculator.add(numbers));
	}
	@Test
	void test_3() {
		String numbers="\"1\\n2,3";
		Assertions.assertEquals(6, Calculator.add(numbers));
	}
	

}
