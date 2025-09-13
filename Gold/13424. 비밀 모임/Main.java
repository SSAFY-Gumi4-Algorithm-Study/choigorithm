import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] graph;
	static int[] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			graph = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					graph[i][j] = 10000;
				}
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph[a][b] = c;
				graph[b][a] = c;
			}

			int k = Integer.parseInt(br.readLine());
			room = new int[k];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				room[i] = Integer.parseInt(st.nextToken());
			}

			floydWarshall();

			sb.append(calcMin(k)).append("\n");
		}

		System.out.println(sb);
	}

	static void floydWarshall() {
		for (int k = 1; k <= n; k++) { // 경유
			for (int i = 1; i <= n; i++) { // 출발
				for (int j = 1; j <= n; j++) { // 도착
					if (i == k || i == j || j == k)
						continue;
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
				}
			}
		}
	}

	static int calcMin(int k) {
		int minSum = Integer.MAX_VALUE;
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			int sum = 0;

			for (int j = 0; j < k; j++) {
				sum += graph[i][room[j]];
			}

			if (minSum > sum) {
				ans = i;
				minSum = sum;
			}
		}
		return ans;
	}
}
