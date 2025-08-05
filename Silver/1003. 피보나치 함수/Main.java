import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine());
		int[] zero = new int[41];
		int[] one = new int[41];

		zero[1] = one[0] = 0;
		zero[0] = one[1] = 1;
		
		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append(zero[n]).append(" ").append(one[n]);
			System.out.println(sb);
		}
	}
}
