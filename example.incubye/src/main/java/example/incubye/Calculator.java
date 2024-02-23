package example.incubye;

import java.util.Arrays;

public class Calculator {

	public static int add(String number) {
		if("".equalsIgnoreCase(number.trim())) {
			return 0;
		}else {
			String [] strArray = number.split(",");
			return  Arrays.stream(strArray).mapToInt(Integer::parseInt).sum()	;
				
		}
		
	}


}
