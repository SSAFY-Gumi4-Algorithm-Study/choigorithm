import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int to, w;

		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	static int n;
	static List<Edge>[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		edgeList = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList[from].add(new Edge(to, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		// 입력 끝

		System.out.println(dijkstra(s, e));
	}

	static int dijkstra(int s, int e) {
		int[] dist = new int[n + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> p1.w - p2.w);

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
		}

		pq.offer(new Edge(s, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.to == e)
				return dist[cur.to];

			if (dist[cur.to] < cur.w)
				continue;

			for (Edge next : edgeList[cur.to]) {
				if (dist[next.to] > cur.w + next.w) {
					dist[next.to] = cur.w + next.w;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		return 0;
	}
}
