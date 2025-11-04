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

	static int ans = 0;
	static char[][] arr = new char[5][5];
	static boolean[] selected = new boolean[25];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = s.charAt(j);
			}
		} // 입력 끝

		pick(0, 0, 0);

		System.out.println(ans);
	}

	static void pick(int idx, int y, int cnt) {
		if (y >= 4) {
			return;
		}

		if (cnt == 7) {
			if (bfs())
				ans++;
			return;
		}

		for (int i = idx; i < 25; i++) {
			selected[i] = true;
			pick(i + 1, arr[i / 5][i % 5] == 'Y' ? y + 1 : y, cnt + 1);
			selected[i] = false;
		}
	}

	static boolean bfs() {
		int cnt = 1;
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[5][5];

		for (int i = 0; i < 25; i++) {
			if (selected[i]) {
				int r = i / 5;
				int c = i % 5;
				q.add(new Point(r, c));
				visited[r][c] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visited[nr][nc] || !selected[nr * 5 + nc])
					continue;

				cnt++;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));
			}
		}

		if (cnt < 7)
			return false;
		return true;
	}
}
