import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] parent;
	static int[] depth;
	static List<Integer>[] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 노드 개수
		parent = new int[n + 1];
		depth = new int[n + 1];
		edge = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edge[a].add(b);
			edge[b].add(a);
		} // 입력1 끝

		dfs(1, 1, 0); // 부모, 깊이 저장

		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(lca(a, b)).append("\n");
		} // 입력2 & 연산

		System.out.println(sb);
	}

	static void dfs(int cur, int p, int d) {
		parent[cur] = p;
		depth[cur] = d;

		for (int next : edge[cur]) {
			if (next == p)
				continue;

			dfs(next, cur, d + 1);
		}
	}

	static int lca(int a, int b) {
		// 깊이 맞추기
		while (depth[a] < depth[b])
			b = parent[b];

		while (depth[a] > depth[b])
			a = parent[a];

		// 공통 부모 찾기
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}
}
