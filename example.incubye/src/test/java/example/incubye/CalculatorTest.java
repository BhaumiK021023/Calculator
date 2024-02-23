package example.incubye;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test_1() throws Exception {
		String numbers="1,2,3,4";
		Assertions.assertEquals(10, Calculator.add(numbers));
	}
	@Test
	void test_2() throws Exception {
		String numbers="";
		Assertions.assertEquals(0, Calculator.add(numbers));
	}
	@Test
	void test_3() throws Exception {
		String numbers="\"1\\n2,3"; 
		Assertions.assertEquals(6, Calculator.add(numbers));
	}
	@Test
	void test_4() throws Exception {
		String numbers="//;\\n1;2";
		Assertions.assertEquals(3, Calculator.add(numbers));
	}
	@Test
	void test_5() throws Exception {
		String numbers="//;\\n1;2,5,-6,-5,-3";
		Exception exception = Assertions.assertThrows(Exception.class, ()->Calculator.add(numbers));
		Assertions.assertEquals("negative numbers not allowed -6,-5,-3", exception.getMessage());
	}
	@Test
	void test_6() throws Exception {
		String numbers="/0,0,0,0,0,1,111,1111";
		Assertions.assertEquals(1223, Calculator.add(numbers));
	}
	@Test
	void test_7() throws Exception {
		String numbers=null;
		Assertions.assertEquals(null, Calculator.add(numbers));
	}
	

}
