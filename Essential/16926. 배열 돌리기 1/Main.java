import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int layer = Math.min(n, m) / 2; // 회전 레이어 수
		// 왼쪽으로, 위로, 오른쪽으로, 아래로
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산
		while (r-- > 0) {
			for (int i = 0; i < layer; i++) {
				int idx = 0;	// 방향
				int row = i, col = i;
				int temp = arr[i][i]; // 첫 번째 값 저장해놓기
				while (idx < 4) {
					int nr = row + dr[idx];
					int nc = col + dc[idx];

					if (nr < i || nc < i || nr >= n - i || nc >= m - i) {	// 범위 벗어나면
						idx++;
						continue;
					}

					arr[row][col] = arr[nr][nc];
					row = nr;
					col = nc;
				}
				arr[i + 1][i] = temp;
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int[] rows : arr) {
			for (int i : rows) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
