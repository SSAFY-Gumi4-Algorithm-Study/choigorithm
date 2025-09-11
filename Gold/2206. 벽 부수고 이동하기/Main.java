import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r, c, broken;

		public Point(int r, int c, int broken) {
			this.r = r;
			this.c = c;
			this.broken = broken;
		}
	}

	static int n, m;
	static int[][] map, visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		List<Point> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		} // 입력 끝

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		int[][][] visited = new int[n][m][2];

		q.offer(new Point(0, 0, 0)); // 0: 안 부숨, 1: 부숨
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.r == n - 1 && cur.c == m - 1) {
				return visited[cur.r][cur.c][cur.broken];
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc][cur.broken] != 0)
					continue;

				if (map[nr][nc] == 1) {
					if (cur.broken == 1)
						continue;
					visited[nr][nc][1] = visited[cur.r][cur.c][cur.broken] + 1;
					q.offer(new Point(nr, nc, 1));
				} else {
					visited[nr][nc][cur.broken] = visited[cur.r][cur.c][cur.broken] + 1;
					q.offer(new Point(nr, nc, cur.broken));
				}
			}
		}

		return -1;
	}
}
