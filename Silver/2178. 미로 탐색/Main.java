import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || arr[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				arr[nr][nc] = arr[r][c] + 1;
				q.add(new int[] { nr, nc });
			}
		}

		return arr[n - 1][m - 1];
	}
}
