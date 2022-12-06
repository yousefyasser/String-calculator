package StringCalculatorKata;

import java.util.Arrays;

public class StringCalculator {
	public int Add(String numbers) throws Exception{
		if(numbers.length() == 0) return 0;
		else if(numbers.length() == 1) return Integer.parseInt(numbers);
		else {
			boolean flag = false;
			String separator = ",";
			
			if(numbers.substring(0, 2).equals("//")) {
				flag = true;
				separator = numbers.charAt(2)+"";
			}
			
			String negatives = "";
			String[] separatedNumbers = numbers.split(separator);
			int sum = 0;
			
			for(int i = 0; i < separatedNumbers.length; i++) {
				if(i == 0 && flag) i++;
				
				String[] newLines = separatedNumbers[i].split("\n");
				for (int j = 0; j < newLines.length; j++) {
					if(newLines[j] != "") {
						int num = Integer.parseInt(newLines[j]);
						if(num < 0) {
							negatives += " " + num;
						}else sum += num;
					}
					
				}
			}
			if(negatives.length() != 0) throw new Exception("negatives not allowed:" + negatives);
			return sum;
		}
	}
}
