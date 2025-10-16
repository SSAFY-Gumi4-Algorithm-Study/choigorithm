import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static int n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int curR = 0, curC = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					curR = i;
					curC = j;
					map[i][j] = 0;
				}
			}
		} // 입력 끝

		System.out.println(bfs(curR, curC));
	}

	static int bfs(int r, int c) {
		int time = 0, cnt = 0, curSize = 2; // 총 시간, 먹은 물고기 수, 현재 상어 크기
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (true) {
			PriorityQueue<Point> pq = new PriorityQueue<>(
					(p1, p2) -> p1.time != p2.time ? Integer.compare(p1.time, p2.time)
							: (p1.r != p2.r ? Integer.compare(p1.r, p2.r) : Integer.compare(p1.c, p2.c)));
			boolean[][] visited = new boolean[n][n];
			boolean eat = false; // 먹었는지 여부

			pq.offer(new Point(r, c, 0));
			visited[r][c] = true;

			while (!pq.isEmpty()) {
				Point cur = pq.poll();

				if (map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < curSize) { // 물고기 먹을 수 있음
					map[cur.r][cur.c] = 0;
					time += cur.time;
					r = cur.r;
					c = cur.c;
					eat = true;
					cnt++;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] || map[nr][nc] > curSize)
						continue;

					pq.offer(new Point(nr, nc, cur.time + 1));
					visited[nr][nc] = true;
				}

			}

			if (!eat)
				break;

			if (cnt == curSize) {
				cnt = 0;
				curSize++;
			}
		}

		return time;
	}
}
