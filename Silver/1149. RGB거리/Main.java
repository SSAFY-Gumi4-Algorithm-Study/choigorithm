import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		int[][] dp = new int[n][3]; // 0: r, 1: g, 2: b
		for (int i = 0; i < 3; i++) {
			dp[0][i] = rgb[0][i];
		}

		for (int i = 1; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = rgb[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
				} else if (j == 1) {
					dp[i][j] = rgb[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
				} else {
					dp[i][j] = rgb[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
				}
			}
		}

		System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
	}
}
