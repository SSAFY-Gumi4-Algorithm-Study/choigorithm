import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String isbn = br.readLine();
		int sum = 0;
		int ans = 0;
		int weight = 1;
		
		for (int i = 0; i < isbn.length(); i++) {
			char c = isbn.charAt(i);
			
			if (c == '*') {
				if (i % 2 == 0)
					weight = 1;
				else
					weight = 3;
				continue;
			}
			
			if (i % 2 == 0) {
				sum += c - '0';
			} else {
				sum += 3 * (c - '0');
			}
		}
		
		for (int i = 0; i < 10; i++) {
			sum += weight * i;
			if (sum % 10 == 0) {
				ans = i;
				break;
			}
			sum -= weight * i;
		}
		
		System.out.println(ans);
	}
}
