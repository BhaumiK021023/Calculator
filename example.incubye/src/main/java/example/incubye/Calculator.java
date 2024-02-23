package example.incubye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
	static Pattern pattern = Pattern.compile("\\d+");

	public static int add(String number) {
		if("".equalsIgnoreCase(number.trim())) {
			return 0;
		}else {
			Matcher matcher = pattern.matcher(number);
			
			List<Integer> digits = new ArrayList();
			while(matcher.find()) {
				digits.add(Integer.parseInt(matcher.group()));
			}
			
			return digits.stream().collect(Collectors.summingInt(Integer::valueOf));
				
		}
		
	}


}
