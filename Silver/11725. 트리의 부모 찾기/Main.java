import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static List<Integer>[] edgeList;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		edgeList = new ArrayList[n + 1];
		ans = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edgeList[from].add(to);
			edgeList[to].add(from);
		} // 입력 끝

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];

		q.offer(1);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : edgeList[cur]) {
				if (visited[next])
					continue;

				ans[next] = cur;
				q.offer(next);
				visited[next] = true;
			}
		}
	}
}
