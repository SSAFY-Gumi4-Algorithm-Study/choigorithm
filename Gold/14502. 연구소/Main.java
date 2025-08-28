import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, ans = 0;
	static int[][] arr, copied;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(ans);
	}

	static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			ans = Math.max(ans, countSafe());
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(cnt + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		copied = new int[n][m];

		for (int i = 0; i < n; i++) {
			copied[i] = arr[i].clone();
		}

		Queue<Point> q = new LinkedList<>();

		// 바이러스 있는 곳
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copied[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}

		// 바이러스 확산
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || copied[nr][nc] != 0)
					continue;

				copied[nr][nc] = 2;
				q.add(new Point(nr, nc));
			}
		}
	}

	static int countSafe() {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copied[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}
}
