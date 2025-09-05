import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static int v;
	static int[] type;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			type = new int[v + 1];
			graph = new ArrayList[v + 1];

			for (int i = 0; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}

			bfs();

		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= v; i++) {
			if (type[i] == 0) {
				q.offer(i);
				type[i] = 1;

				while (!q.isEmpty()) {
					int cur = q.poll();

					for (int next : graph[cur]) {
						if (type[next] == type[cur]) {
							sb.append("NO").append("\n");
							return;
						}

						if (type[next] != 0)
							continue;

						type[next] = -type[cur];
						q.offer(next);
					}
				}
			}
		}

		sb.append("YES").append("\n");
	}
}
