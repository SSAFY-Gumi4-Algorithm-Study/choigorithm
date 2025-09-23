import java.util.*;
import java.io.*;

public class Main {
	static class Consult {
		int t, p;

		public Consult(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Consult[] consults = new Consult[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			consults[i] = new Consult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		} // 입력 끝

		int[] dp = new int[n + 1]; // idx일까지의 최대 수익

		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			int end = i + consults[i].t - 1; // 끝나는 날
			if (end <= n)
				dp[end] = Math.max(dp[end], dp[i - 1] + consults[i].p);
		}

		System.out.println(dp[n]);
	}
}
