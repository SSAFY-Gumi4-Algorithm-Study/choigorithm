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
	static int[][] arr;
	static Queue<Point> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		q = new LinkedList<>();
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					q.offer(new Point(i, j));
					visited[i][j] = true;
				}

			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					sb.append(-1).append(" ");
				else if (arr[i][j] == 0)
					sb.append(arr[i][j]).append(" ");
				else
					sb.append(arr[i][j] - 2).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || arr[nr][nc] != 1)
					continue;

				visited[nr][nc] = true;
				arr[nr][nc] = arr[cur.r][cur.c] + 1;
				q.add(new Point(nr, nc));
			}
		}
	}
}
