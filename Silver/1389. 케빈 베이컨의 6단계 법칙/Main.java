import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		adj = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(adj[i], 101);
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		} // 입력 끝

		FloydWarshall();

		System.out.println(calcMin());
	}

	static void FloydWarshall() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
	}

	static int calcMin() {
		int minSum = Integer.MAX_VALUE;
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += adj[i][j];
			}
			if (sum < minSum) {
				minSum = sum;
				ans = i;
			}
		}

		return ans;
	}
}
