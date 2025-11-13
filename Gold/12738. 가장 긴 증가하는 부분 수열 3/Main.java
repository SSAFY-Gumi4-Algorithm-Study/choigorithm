import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(lis(n, arr));
	}

	static int lis(int n, int[] arr) {
		int[] dp = new int[n];

		int end = 0;
		for (int i = 0; i < n; i++) {
			int pos = lower_bound(dp, end, arr[i]);
			if (pos == end) {
				dp[end++] = arr[i];
			}
			dp[pos] = arr[i];
		}

		return end;
	}

	static int lower_bound(int[] dp, int end, int num) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;

			if (dp[mid] >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}
}
