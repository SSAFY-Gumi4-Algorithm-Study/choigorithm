import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = Integer.parseInt(st.nextToken());
			}

			int ans = 1;
			int minRank = arr[1];
			for (int i = 2; i <= n; i++) {
				if (minRank > arr[i]) {
					ans++;
					minRank = arr[i];
				}
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
