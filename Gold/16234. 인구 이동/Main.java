import java.util.*;
import java.io.*;

public class Main {
	static int n, left, right;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean moved;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		left = Integer.parseInt(st.nextToken());
		right = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;

		while (true) {
			visited = new boolean[n][n];
			moved = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						List<int[]> union = new ArrayList<>();
						int sum = dfs(i, j, union);
						if (union.size() > 1) {
							move(union, sum);
							moved = true;
						}
					}
				}
			}

			if (!moved)
				break;
			ans++;
		}

		System.out.println(ans);
	}

	static int dfs(int r, int c, List<int[]> union) {
		visited[r][c] = true;
		union.add(new int[] { r, c });
		int sum = arr[r][c];

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
				continue;

			int diff = Math.abs(arr[r][c] - arr[nr][nc]);
			if (diff >= left && diff <= right) {
				sum += dfs(nr, nc, union);
			}
		}

		return sum;
	}

	static void move(List<int[]> union, int sum) {
		int avg = sum / union.size();

		for (int[] pos : union) {
			arr[pos[0]][pos[1]] = avg;
		}
	}
}
