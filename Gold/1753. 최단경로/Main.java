import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int to, w;

		public Edge(int node, int w) {
			this.to = node;
			this.w = w;
		}
	}

	static int v, e, k;
	static int[] dist;
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		graph = new ArrayList[v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;

		for (int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(b, w));
		}

		dijkstra();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dist[i]).append("\n");
		}

		System.out.println(sb);
	}

	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		pq.offer(new Edge(k, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.w > dist[cur.to])
				continue;

			for (Edge next : graph[cur.to]) {
				if (cur.w + next.w < dist[next.to]) {
					dist[next.to] = cur.w + next.w;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}
}
