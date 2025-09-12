import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r, c, wall;

		public Point(int r, int c, int wall) {
			this.r = r;
			this.c = c;
			this.wall = wall;
		}
	}

	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.wall - p2.wall);
		boolean[][] visited = new boolean[n][m];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		pq.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (cur.r == n - 1 && cur.c == m - 1)
				return cur.wall;

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
					continue;

				if (map[nr][nc] == 1) {
					pq.offer(new Point(nr, nc, cur.wall + 1));
				} else {
					pq.offer(new Point(nr, nc, cur.wall));
				}

				visited[nr][nc] = true;
			}
		}

		return 0;
	}
}
