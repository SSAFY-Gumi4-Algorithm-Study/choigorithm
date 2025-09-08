import java.util.*;
import java.io.*;

public class Main {
	static class App {
		int m, c;

		public App(int m, int c) {
			this.m = m;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		App[] apps = new App[n];
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			apps[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
			sum += apps[i].c;
		}

		int[] dp = new int[sum + 1];

		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= apps[i].c; j--) {
				dp[j] = Math.max(dp[j], dp[j - apps[i].c] + apps[i].m);
			}
		}

		for (int i = 0; i <= sum; i++) {
			if (dp[i] >= m) {
				System.out.println(i);
				break;
			}
		}
	}
}
