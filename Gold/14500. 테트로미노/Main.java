import java.io.*;
import java.util.*;

public class Main {

	static int n, m, ans = 0;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
				continue;

			if (cnt == 2) { // ㅗ, ㅜ, ㅏ, ㅓ
				visited[nr][nc] = true;
				dfs(r, c, cnt + 1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}

			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
}
