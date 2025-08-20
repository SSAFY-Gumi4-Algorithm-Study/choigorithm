import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[][] arr;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[101][101];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					arr[j][k] = true;
				}
			}
		}

		int ans = 0;
		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };
		for (int r = 0; r <= 100; r++) {
			for (int c = 0; c <= 100; c++) {
				if (arr[r][c]) {
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr < 0 || nc < 0 || nr > 101 || nc > 101) {
							ans++;
						} else if (!arr[nr][nc]) {
							ans++;
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

}
