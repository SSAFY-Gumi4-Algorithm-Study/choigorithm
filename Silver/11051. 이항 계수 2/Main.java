import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
