package example;

public class StringCalculator {
	public int Add(String numbers) {
		if(numbers.length() == 0) return 0;
		else if(numbers.length() == 1) return Integer.parseInt(numbers);
		else {
			String[] separatedNumbers = numbers.split(",");
			int sum = 0;
			
			for(int i = 0; i < separatedNumbers.length; i++) {
				sum += Integer.parseInt(separatedNumbers[i]);
			}
			
			return sum;
		}
	}
}
