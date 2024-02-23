package example.incubye;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		String numbers="1,2,3,4";
		Assertions.assertEquals(10, Calculator.add(numbers));
	}

}
