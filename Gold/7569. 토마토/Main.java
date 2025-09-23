import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int p, r, c;

		public Point(int p, int r, int c) {
			this.p = p;
			this.r = r;
			this.c = c;
		}
	}

	static int m, n, h;
	static int[][][] box;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		q = new ArrayDeque<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.offer(new Point(i, j, k));
					}
				}
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
		int[] dp = { -1, 1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, 0, 0, 1, -1 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int np = cur.p + dp[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (np < 0 || nr < 0 || nc < 0 || np >= h || nr >= n || nc >= m || box[np][nr][nc] != 0)
					continue;

				box[np][nr][nc] = box[cur.p][cur.r][cur.c] + 1;
				q.offer(new Point(np, nr, nc));
			}
		}

		int ans = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 0) {
						return -1;
					}
					ans = Math.max(ans, box[i][j][k]);
				}
			}
		}

		return ans - 1;
	}
}
