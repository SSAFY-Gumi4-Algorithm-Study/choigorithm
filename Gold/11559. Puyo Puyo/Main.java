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

	static char[][] field = new char[12][6];
	static boolean[][] visited = new boolean[12][6];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				field[i][j] = s.charAt(j);
			}
		} // 입력 끝

		int ans = 0;
		boolean flag = true; // 터졌는지

		while (flag) {
			flag = false;

			visited = new boolean[12][6];

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (field[i][j] == '.')
						continue;

					if (bfs(i, j)) {
						flag = true;
					}
				}
			}

			if (flag) {
				ans++;
				reset();
			}
		}

		System.out.println(ans);
	}

	static boolean bfs(int r, int c) {
		int cnt = 1;
		Queue<Point> q = new ArrayDeque<>();
		Queue<Point> selected = new ArrayDeque<>();

		q.add(new Point(r, c));
		selected.add(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || field[nr][nc] != field[r][c] || visited[nr][nc])
					continue;

				cnt++;
				q.add(new Point(nr, nc));
				selected.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}

		if (cnt >= 4) {
			puyo(selected);
			return true;
		}

		return false;
	}

	static void puyo(Queue<Point> selected) {
		while (!selected.isEmpty()) {
			Point cur = selected.poll();
			field[cur.r][cur.c] = '.';
		}
	}

	static void reset() {
		for (int j = 0; j < 6; j++) {
			int dot = 0;
			Queue<Character> q = new ArrayDeque<>();

			for (int i = 0; i < 12; i++) {
				if (field[i][j] == '.') {
					dot++;
					continue;
				}

				q.add(field[i][j]);
			}

			for (int i = 0; i < 12; i++) {
				if (dot > 0) {
					field[i][j] = '.';
					dot--;
					continue;
				}

				field[i][j] = q.poll();
			}
		}
	}
}
