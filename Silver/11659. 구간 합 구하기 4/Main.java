import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}

		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(dp[j] - dp[i - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
