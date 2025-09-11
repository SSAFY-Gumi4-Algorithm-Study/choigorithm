import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r, c, key;

		public Point(int r, int c, int key) {
			this.r = r;
			this.c = c;
			this.key = key;
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

		int r = 0, c = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		} // 입력 끝

		System.out.println(bfs(r, c));
	}

	static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][][] visited = new int[n][m][64];

		q.offer(new Point(r, c, 0));
		visited[r][c][0] = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (map[cur.r][cur.c] == '1')
				return visited[cur.r][cur.c][cur.key] - 1;

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == '#' || visited[nr][nc][cur.key] != 0) {
					continue;
				}

				if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 문
					if ((cur.key & (1 << map[nr][nc] - 'a')) == 0) // 열쇠 없음
						continue;
					q.offer(new Point(nr, nc, cur.key));
					visited[nr][nc][cur.key] = visited[cur.r][cur.c][cur.key] + 1;
				} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠
					int key = cur.key | (1 << (map[nr][nc] - 'a'));
					q.offer(new Point(nr, nc, key));
					visited[nr][nc][key] = visited[cur.r][cur.c][cur.key] + 1;
				} else { // 빈 칸
					q.offer(new Point(nr, nc, cur.key));
					visited[nr][nc][cur.key] = visited[cur.r][cur.c][cur.key] + 1;
				}
			}
		}

		return -1;
	}
}
