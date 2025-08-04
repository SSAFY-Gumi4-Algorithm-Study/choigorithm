import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		// 입력
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 연산
		Arrays.sort(arr);
		
		int out = (int) Math.round(n * 0.15);
		int sum = 0;
		
		for (int i = out; i < n - out; i++) {
			sum += arr[i];
		}
		
		System.out.println((int) Math.round((double) sum / (n - out * 2)));
	}
}
