import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		int[] dp = new int[n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			int pos = lower_bound(idx, dp, arr[i]);
			if (pos == idx)
				dp[idx++] = arr[i];
			dp[pos] = arr[i];
		}

		System.out.println(arr.length - idx);
	}

	static int lower_bound(int end, int[] dp, int num) {
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
