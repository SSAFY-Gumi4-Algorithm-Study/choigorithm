import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		dp[0][0] = arr[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}
		}

		int ans = 0;
		for (int i : dp[n - 1]) {
			ans = Math.max(ans, i);
		}
		System.out.println(ans);
	}
}
