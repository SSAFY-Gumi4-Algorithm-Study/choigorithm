import java.util.*;
import java.io.*;

public class Main {
	static int n, m, r, c, dir, ans = 0;
	static int[][] arr;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			first();

			if (arr[r + 1][c] == 0 || arr[r][c + 1] == 0 || arr[r - 1][c] == 0 || arr[r][c - 1] == 0) {
				third();
			} else {
				if (second())
					continue;
				else
					break;
			}
		}

		System.out.println(ans);
	}

	static void first() {
		if (arr[r][c] == 0) {
			arr[r][c] = 2;
			ans++;
		}
	}

	static boolean second() {
		int nr = r - dr[dir];
		int nc = c - dc[dir];

		if (arr[nr][nc] == 1)
			return false;

		r = nr;
		c = nc;
		return true;
	}

	static void third() {
		dir = (dir - 1) < 0 ? 3 : (dir - 1);

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (arr[nr][nc] != 0)
			return;

		r = nr;
		c = nc;
	}
}
