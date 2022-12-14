package StringCalculatorKata;

public class StringCalculator {
	public static String getSeparators(String numbers) {
		String separator = "";
		boolean write = false;
		
		for(int i = 2; i < numbers.length()-1; i++) {
			if(numbers.charAt(i) == '[') {
				write = true;
				separator += "\\";
				continue;
			}else if(numbers.charAt(i) == ']') {
				if(numbers.charAt(i+1) == '[') separator += "|";
				write = false;
				continue;
			}
			
			if(write) separator += numbers.charAt(i);
		}
		
		return separator;
	}
	
	public int Add(String numbers) throws Exception{
		if(numbers.length() == 0) return 0;
		else if(numbers.length() == 1) return Integer.parseInt(numbers);
		else {
			boolean flag = false;
			int sum = 0;
			String separator = "", negatives = "";
			
			
			if(numbers.substring(0, 2).equals("//")) {
				if(numbers.charAt(2) == '[')
					separator = getSeparators(numbers);
				else
					separator = numbers.charAt(2)+"";
				
				flag = true;
			}else
				separator = ",";
			
			String[] separatedNumbers = numbers.split(separator+"|\n");
			
			for(int i = 0; i < separatedNumbers.length; i++) {
				if(i == 0 && flag) i++;
				
				try {
					int num = Integer.parseInt(separatedNumbers[i]);
					
					if(num < 0) 
						negatives += " " + num;
					else if(num < 1001) 
						sum += num;
				}catch(Exception e){
					continue;
				}
				
			}
			
			if(negatives.length() != 0) 
				throw new Exception("negatives not allowed:" + negatives);
			
			return sum;
		}
	}
}
