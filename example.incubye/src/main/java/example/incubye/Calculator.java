package example.incubye;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
	static Pattern pattern = Pattern.compile("-?\\d+");
	static Predicate<Long> isNegative = num-> num<0;

	public static Long add(String number) throws NegativeNumberException  {
		if(Objects.nonNull(number)){
			if("".equalsIgnoreCase(number.trim())) {
				return 0L;
			}else {
				Matcher matcher = pattern.matcher(number);
				
				List<Long> digits = new ArrayList<Long>();
				while(matcher.find()) {
					
					digits.add(Long.parseLong(matcher.group()));
				}
				
				List<Long> negativeCount = digits.stream().filter(isNegative).collect(Collectors.toList());
				if(negativeCount.isEmpty()) {
					return digits.stream().collect(Collectors.summingLong(Long::valueOf));
					
				}else {
					String commaSeparated= negativeCount.stream().map(String::valueOf).collect(Collectors.joining(","));
					
					throw new NegativeNumberException("negative numbers not allowed "+commaSeparated);
				}
				
			}	
		}else {
			return null;
		}
		
		
	}


}