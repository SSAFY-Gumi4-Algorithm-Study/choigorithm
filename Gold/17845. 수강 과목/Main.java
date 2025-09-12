import java.util.*;
import java.io.*;

public class Main {
	static class Subject {
		int i, t;

		public Subject(int i, int t) {
			this.i = i;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Subject[] sub = new Subject[k];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			sub[i] = new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		} // 입력 끝

		int[] dp = new int[n + 1];
		for (int i = 0; i < k; i++) {
			for (int j = n; j >= sub[i].t; j--) {
				dp[j] = Math.max(dp[j], dp[j - sub[i].t] + sub[i].i);
			}
		}

		System.out.println(dp[n]);
	}
}
