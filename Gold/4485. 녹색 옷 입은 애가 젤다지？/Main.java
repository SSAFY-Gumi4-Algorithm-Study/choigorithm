import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int r, c, w;

		public Edge(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	static int n;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			if (n == 0)
				break;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {

					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(t++).append(": ").append(dijkstra()).append("\n");
		}

		System.out.println(sb);
	}

	static int dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
		int[][] dist = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		pq.offer(new Edge(0, 0, arr[0][0]));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.r == n - 1 && cur.c == n - 1) {
				return dist[n - 1][n - 1];
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] || dist[nr][nc] < cur.w + arr[nr][nc])
					continue;

				visited[nr][nc] = true;
				dist[nr][nc] = cur.w + arr[nr][nc];
				pq.offer(new Edge(nr, nc, dist[nr][nc]));
			}
		}
		return -1;
	}

}
