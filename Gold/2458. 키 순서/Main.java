import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new boolean[n + 1][n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = true;
		}

		floydWarshall();

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] || graph[j][i]) {
					cnt++;
				}

			}
			if (cnt == n - 1)
				ans++;
		}

		System.out.println(ans);
	}

	static void floydWarshall() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] && graph[k][j])
						graph[i][j] = true;
				}
			}
		}
	}
}
