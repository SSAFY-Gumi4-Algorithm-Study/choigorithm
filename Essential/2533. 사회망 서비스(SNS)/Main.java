import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		dp = new int[2][n + 1]; // 자식 중 얼리어답터 수 저장. (0: 얼리어답터 X, 1: 얼리어답터 O)

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		} // 입력 끝

		dfs(1);

		System.out.println(Math.min(dp[0][1], dp[1][1]));
	}

	static void dfs(int cur) {
		visited[cur] = true;
		dp[0][cur] = 0;
		dp[1][cur] = 1;

		for (int child : graph[cur]) {
			if (visited[child])
				continue;

			dfs(child);
			dp[0][cur] += dp[1][child]; // 자식이 무조건 얼리어답터
			dp[1][cur] += Math.min(dp[0][child], dp[1][child]);
		}
	}
}
