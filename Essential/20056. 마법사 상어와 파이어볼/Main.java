import java.util.*;
import java.io.*;

public class Main {
	static class FireBall {
		int r, c, m, s, d;

		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int n;
	static ArrayList<FireBall>[][] map;
	static ArrayList<FireBall> fireBall;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new ArrayList[n][n];
		fireBall = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			fireBall.add(new FireBall(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		} // 입력 끝

		while (k-- > 0) { // 명령
			move();

			// 파이어볼 분리 & map 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].size() < 2) {
						map[i][j].clear();
						continue;
					}
					divide(i, j);
				}
			}
		}

		System.out.println(calcSum());
	}

	static void move() { // 파이어볼 이동
		for (FireBall f : fireBall) {
			f.r = (f.r + n + dr[f.d] * (f.s % n)) % n;
			f.c = (f.c + n + dc[f.d] * (f.s % n)) % n;
			map[f.r][f.c].add(f);
		}
	}

	static void divide(int r, int c) { // 파이어볼 분리
		int m = 0, s = 0, cnt = map[r][c].size();
		boolean odd = false, even = false;

		for (FireBall cur : map[r][c]) {
			m += cur.m;
			s += cur.s;
			if (cur.d % 2 == 0)
				even = true;
			else
				odd = true;

			fireBall.remove(cur);
		}
		map[r][c].clear();

		m /= 5;
		if (m == 0) { // 소멸
			return;
		}

		s /= cnt;

		if (odd && even) {
			for (int i = 1; i < 8; i += 2) {
				fireBall.add(new FireBall(r, c, m, s, i));
			}
		} else {
			for (int i = 0; i < 8; i += 2) {
				fireBall.add(new FireBall(r, c, m, s, i));
			}
		}
	}

	static int calcSum() { // 질량 합
		int ans = 0;

		for (FireBall f : fireBall) {
			ans += f.m;
		}

		return ans;
	}
}
