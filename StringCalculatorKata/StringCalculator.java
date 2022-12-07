package StringCalculatorKata;

import java.util.Arrays;

public class StringCalculator {
	public int Add(String numbers) throws Exception{
		if(numbers.length() == 0) return 0;
		else if(numbers.length() == 1) return Integer.parseInt(numbers);
		else {
			boolean flag = false;
			int sum = 0;
			String separator = "", negatives = "";
			
			
			if(numbers.substring(0, 2).equals("//")) {
				if(numbers.charAt(2) == '[') 
					for(int i = 3; i < numbers.length() && numbers.charAt(i) != ']'; i++) 
						separator += numbers.charAt(i);
				else
					separator = numbers.charAt(2)+"";
				
				flag = true;
			}else
				separator = ",";
			
			String[] separatedNumbers = numbers.split("\\" + separator);
			
			for(int i = 0; i < separatedNumbers.length; i++) {
				if(i == 0 && flag) i++;
				
				String[] newLines = separatedNumbers[i].split("\n");
				for (int j = 0; j < newLines.length; j++) {
					try {
						int num = Integer.parseInt(newLines[j]);
						
						if(num < 0) 
							negatives += " " + num;
						else if(num < 1001) 
							sum += num;
					}catch(Exception e){
						continue;
					}
					
				}
			}
			
			if(negatives.length() != 0) 
				throw new Exception("negatives not allowed:" + negatives);
			
			return sum;
		}
	}
}
