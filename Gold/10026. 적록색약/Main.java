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

	static int n;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		char[][] rgb = new char[n][n];
		char[][] rb = new char[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				rgb[i][j] = s.charAt(j);
				rb[i][j] = s.charAt(j);
				if (rb[i][j] == 'G')
					rb[i][j] = 'R';
			}
		} // 입력 끝

		int ans1 = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j])
					ans1 += bfs(i, j, rgb, rgb[i][j]);
			}
		}

		int ans2 = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j])
					ans2 += bfs(i, j, rb, rb[i][j]);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans1).append(" ").append(ans2);
		System.out.println(sb);
	}

	static int bfs(int r, int c, char[][] map, char color) {
		Queue<Point> q = new ArrayDeque<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		q.offer(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] || map[nr][nc] != color)
					continue;

				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}

		return 1;
	}
}
