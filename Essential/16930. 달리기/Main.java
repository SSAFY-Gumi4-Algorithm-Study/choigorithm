import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, k, sr, sc, er, ec;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == '.') {
					map[i][j] = -1; // 미방문
				} else {
					map[i][j] = -2; // 벽
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		er = Integer.parseInt(st.nextToken()) - 1;
		ec = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Point> q = new LinkedList<>();

		map[sr][sc] = 0;
		q.offer(new Point(sr, sc));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= k; j++) {
					int nr = cur.r + dr[i] * j;
					int nc = cur.c + dc[i] * j;

					if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == -2)
						break;

					if (map[nr][nc] == -1) { // 미방문
						q.offer(new Point(nr, nc));
						map[nr][nc] = map[cur.r][cur.c] + 1;
					} else if (map[nr][nc] < map[cur.r][cur.c] + 1) { // 이미 현재 시간 이하로 도착했음.
						break;
					}
				}
			}
		}
		return map[er][ec];
	}
}
