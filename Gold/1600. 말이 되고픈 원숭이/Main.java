import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r, c, jump;

		public Point(int r, int c, int jump) {
			this.r = r;
			this.c = c;
			this.jump = jump;
		}
	}

	static int w, h, k;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2 };
		int[][][] visited = new int[h][w][k + 1];

		q.offer(new Point(0, 0, 0));
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.r == h - 1 && cur.c == w - 1)
				return visited[cur.r][cur.c][cur.jump] - 1;

			for (int i = 0; i < 12; i++) {
				if (i >= 4 && cur.jump >= k)
					break;

				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == 1) {
					continue;
				}

				if (i >= 4) {
					if (visited[nr][nc][cur.jump + 1] != 0)
						continue;
					q.offer(new Point(nr, nc, cur.jump + 1));
					visited[nr][nc][cur.jump + 1] = visited[cur.r][cur.c][cur.jump] + 1;
				} else {
					if (visited[nr][nc][cur.jump] != 0)
						continue;
					q.offer(new Point(nr, nc, cur.jump));
					visited[nr][nc][cur.jump] = visited[cur.r][cur.c][cur.jump] + 1;
				}
			}
		}

		return -1;
	}
}
