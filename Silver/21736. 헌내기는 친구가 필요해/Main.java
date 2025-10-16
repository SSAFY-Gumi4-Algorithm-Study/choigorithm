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

	static int n, m;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		int sr = 0, sc = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					sr = i;
					sc = j;
				}
			}
		}

		int ans = bfs(sr, sc);

		if (ans == 0)
			System.out.println("TT");
		else
			System.out.println(ans);
	}

	static int bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int ans = 0;

		q.offer(new Point(r, c));
		map[r][c] = 'X';

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 'X')
					continue;

				if (map[nr][nc] == 'P')
					ans++;

				q.offer(new Point(nr, nc));
				map[nr][nc] = 'X';
			}
		}

		return ans;
	}
}
