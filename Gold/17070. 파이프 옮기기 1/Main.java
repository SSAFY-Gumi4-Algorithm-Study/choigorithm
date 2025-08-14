import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int n, ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j= 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(ans);
	}

	static void dfs(int r, int c, int dir) { // r, c: 오른쪽 파이프 위치
		if (r == n - 1 && c == n - 1) {
			ans++;
			return;
		}

		// 0: 가로, 1: 세로, 2: 대각선
		if ((dir == 0 || dir == 2) && (c + 1 < n) && (arr[r][c + 1] == 0)) {
			dfs(r, c + 1, 0);
		} 
		if ((dir == 1 || dir == 2) && (r + 1 < n) && (arr[r + 1][c] == 0)) {
			dfs(r + 1, c, 1);
		}
		if ((r + 1 < n) && (c + 1 < n) && (arr[r + 1][c] == 0) && (arr[r][c + 1] == 0) && (arr[r + 1][c + 1] == 0)) { 
			dfs(r + 1, c + 1, 2);
		}
			
	}
}
