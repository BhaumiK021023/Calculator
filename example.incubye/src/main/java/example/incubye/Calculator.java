package example.incubye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
	static Pattern pattern = Pattern.compile("-?\\d+");
	static Predicate<Integer> isNegative = num-> num<0;

	public static int add(String number) throws Exception {
		if("".equalsIgnoreCase(number.trim())) {
			return 0;
		}else {
			Matcher matcher = pattern.matcher(number);
			
			List<Integer> digits = new ArrayList<Integer>();
			while(matcher.find()) {
				
				digits.add(Integer.parseInt(matcher.group()));
			}
			
			List<Integer> negativeCount = digits.stream().filter(isNegative).collect(Collectors.toList());
			if(negativeCount.isEmpty()) {
				return digits.stream().collect(Collectors.summingInt(Integer::valueOf));
				
			}else {
				String commaSeparated= negativeCount.stream().map(String::valueOf).collect(Collectors.joining(","));
				
				throw new Exception("negative numbers not allowed "+commaSeparated);
			}
			
			
				
		}
		
	}


}
