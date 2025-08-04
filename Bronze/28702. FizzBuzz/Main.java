import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();
			if (!s.equals("Fizz") && !s.equals("Buzz") && !s.equals("FizzBuzz")) {
				num = Integer.parseInt(s);
			}
			
			if (num != 0) {
				num++;
			}
		}
		
		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(num);
		}
	}
}
