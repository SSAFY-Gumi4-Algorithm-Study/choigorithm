import java.io.*;
import java.util.*;

public class Main {

	static int n, cnt;
	static boolean[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new boolean[n][n];
		ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]) {
					cnt = 0;
					dfs(i, j);
					ans.add(cnt);
				}
			}
		}

		ans.sort((a, b) -> a - b);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for (int i : ans) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

	static void dfs(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= n || !arr[r][c]) {
			return;
		}

		arr[r][c] = false;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			dfs(nr, nc);
		}
	}
}
