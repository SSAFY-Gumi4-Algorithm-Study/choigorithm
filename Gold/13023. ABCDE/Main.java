import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = 0;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			if (ans == 1)
				break;
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}

		System.out.println(ans);

	}

	static void dfs(int idx, int depth) {
		if (ans == 1)
			return;

		if (depth == 5) {
			ans = 1;
			return;
		}

		for (int x : list[idx]) {
			if (visited[x])
				continue;
			visited[x] = true;
			dfs(x, depth + 1);
			visited[x] = false;
		}
	}
}
