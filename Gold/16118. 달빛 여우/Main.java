import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int to, state;
		long w;

		public Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}

		public Edge(int to, long w, int state) {
			this.to = to;
			this.w = w;
			this.state = state;
		}
	}

	static int n, m;
	static long[] fox;
	static long[][] wolf;
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			graph[a].add(new Edge(b, w * 2));
			graph[b].add(new Edge(a, w * 2));
		}

		fox = new long[n + 1];
		wolf = new long[2][n + 1];
		Arrays.fill(fox, Long.MAX_VALUE);
		fox[1] = 0;
		for (int i = 0; i < 2; i++) {
			Arrays.fill(wolf[i], Long.MAX_VALUE);
		}
		wolf[0][1] = 0;

		dijkstraFox();
		dijkstraWolf();

		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (fox[i] < Math.min(wolf[0][i], wolf[1][i]))
				ans++;
		}

		System.out.println(ans);
	}

	static int dijkstraFox() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.w, e2.w));
		boolean[] visited = new boolean[n + 1];

		pq.offer(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.to] || fox[cur.to] < cur.w)
				continue;

			visited[cur.to] = true;

			for (Edge next : graph[cur.to]) {
				if (fox[next.to] > next.w + cur.w) {
					fox[next.to] = next.w + cur.w;
					pq.offer(new Edge(next.to, fox[next.to]));
				}
			}
		}
		return 0;
	}

	static int dijkstraWolf() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.w, e2.w));
		boolean[][] visited = new boolean[2][n + 1];

		pq.offer(new Edge(1, 0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.state][cur.to] || cur.w > wolf[cur.state][cur.to])
				continue;

			visited[cur.state][cur.to] = true;

			int nextState = 1 - cur.state;
			for (Edge next : graph[cur.to]) {
				long dist = 0;
				if (nextState == 0) {
					dist = next.w * 2 + cur.w;
				} else {
					dist = next.w / 2 + cur.w;
				}

				if (wolf[nextState][next.to] > dist) {
					wolf[nextState][next.to] = dist;
					pq.offer(new Edge(next.to, dist, nextState));
				}
			}
		}
		return 0;
	}

}
