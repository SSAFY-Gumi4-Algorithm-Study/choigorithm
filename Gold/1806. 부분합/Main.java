import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int ans = n + 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		int left = 0, right = 0;
		int sum = 0;
		while (left <= right && right <= n) {
			if (sum < s) {
				sum += arr[right++];
			} else {
				ans = Math.min(ans, right - left);
				sum -= arr[left++];
			}
		}

		System.out.println(ans > n ? 0 : ans);
	}
}
