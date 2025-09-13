import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int x, time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static final int MAX_DIST = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(n, k));
	}

	static int dijkstra(int n, int k) {
		int[] dist = new int[MAX_DIST + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);

		pq.offer(new Point(n, 0));
		dist[n] = 0;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if (cur.time > dist[cur.x])
				continue;

			if (cur.x == k)
				return dist[k];

			for (int i = 0; i < 3; i++) {
				int nx = nextX(i, cur.x);

				if (nx < 0 || nx > MAX_DIST)
					continue;

				int nTime;
				if (i == 2) {
					nTime = cur.time;
				} else {
					nTime = cur.time + 1;
				}

				if (nTime < dist[nx]) {
					pq.offer(new Point(nx, nTime));
					dist[nx] = nTime;
				}
			}
		}

		return dist[k];
	}

	static int nextX(int i, int x) {
		if (i == 0)
			return x - 1;
		else if (i == 1)
			return x + 1;
		else
			return x * 2;
	}
}
