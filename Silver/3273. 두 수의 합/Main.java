import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		int ans = 0;
		
		// 연산
		// [start] + [end] > x: end--
		// [start] + [end] < x: start++
		Arrays.sort(arr);
		
		int start = 0;
		int end = n - 1;
		while (start < end) {
			if (arr[start] + arr[end] > x)
				end--;
			else if (arr[start] + arr[end] < x)
				start++;
			else {
				ans++;
				start++;
			}
		}
		
		// 출력
		System.out.println(ans);
	}
}
