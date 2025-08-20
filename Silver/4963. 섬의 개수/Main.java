import java.util.*;
import java.io.*;

public class Main {

	static int w, h;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1)
						cnt += bfs(i, j);
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);

	}

	static int bfs(int r, int c) {
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] rc = q.poll();
			r = rc[0];
			c = rc[1];

			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= h || nc >= w || arr[nr][nc] == 0)
					continue;

				arr[nr][nc] = 0;
				q.add(new int[] { nr, nc });
			}
		}

		return 1;
	}
}
