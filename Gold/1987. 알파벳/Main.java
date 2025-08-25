import java.io.*;
import java.util.*;

public class Main {

	static int row, col;
	static char[][] arr;
	static boolean[] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new char[row][col];
		visited = new boolean[26];

		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		visited[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt) {
		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= row || nc >= col || visited[arr[nr][nc] - 'A'])
				continue;

			flag = true;
			visited[arr[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			visited[arr[nr][nc] - 'A'] = false;
		}

		if (!flag)
			ans = Math.max(ans, cnt);
	}
}
