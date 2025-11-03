import java.util.*;
import java.io.*;

public class Main {
	static int r, c;
	static int cleaner; // 공기청정기 아래 행
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] rr = { -1, 0, 1, 0, 1, 0, -1, 0 };
	static int[] rc = { 0, 1, 0, -1, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					cleaner = i;
			}
		} // 입력 끝

		while (t-- > 0) {
			spread();
			clean();
		}

		System.out.println(calcSum());
	}

	static void spread() {
		int[][] newMap = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 0) // 빈 칸
					continue;

				if (map[i][j] == -1) { // 공기 청정기
					newMap[i][j] = -1;
					continue;
				}

				int value = map[i][j] / 5;
				int cnt = 0;

				for (int dir = 0; dir < 4; dir++) { // 인접 4방향으로 확산
					int nr = i + dr[dir];
					int nc = j + dc[dir];

					if (nr < 0 || nc < 0 || nr >= r || nc >= c || map[nr][nc] == -1) // 칸 없음, 공기청정기
						continue;

					newMap[nr][nc] += value;
					cnt++;
				}
				newMap[i][j] += map[i][j] - value * cnt; // 남은 미세먼지
			}
		}

		map = newMap;
	}

	static void clean() {
		int curR = cleaner - 2;
		int curC = 0;

		for (int dir = 0; dir < 4; dir++) {
			while (true) {

				int nr = curR + rr[dir];
				int nc = curC + rc[dir];

				if (nr < 0 || nc < 0 || nr >= cleaner || nc >= c)
					break;

				if (map[nr][nc] == -1) {
					map[curR][curC] = 0;
					break;
				}

				map[curR][curC] = map[nr][nc];
				curR = nr;
				curC = nc;
			}
		}

		curR = cleaner + 1;
		curC = 0;

		for (int dir = 4; dir < 8; dir++) {
			while (true) {

				int nr = curR + rr[dir];
				int nc = curC + rc[dir];

				if (nr < cleaner || nc < 0 || nr >= r || nc >= c)
					break;

				if (map[nr][nc] == -1) {
					map[curR][curC] = 0;
					break;
				}

				map[curR][curC] = map[nr][nc];
				curR = nr;
				curC = nc;
			}
		}
	}

	static int calcSum() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum += map[i][j];
			}
		}
		return sum + 2; // 공기청정기(-2) 복구
	}
}
