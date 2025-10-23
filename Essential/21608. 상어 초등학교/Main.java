import java.util.*;
import java.io.*;

public class Main {
	static class Seat implements Comparable<Seat> {
		int r, c, prefer, empty;

		public Seat(int r, int c, int prefer, int empty) {
			this.r = r;
			this.c = c;
			this.prefer = prefer;
			this.empty = empty;
		}

		public int compareTo(Seat other) {
			if (prefer != other.prefer)
				return Integer.compare(other.prefer, prefer);

			if (empty != other.empty)
				return Integer.compare(other.empty, empty);

			if (r != other.r)
				return Integer.compare(r, other.r);

			return Integer.compare(c, other.c);
		}
	}

	static int n;
	static int[] students;
	static int[][] seats;
	static Map<Integer, Set<Integer>> preferences;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		students = new int[n * n];
		seats = new int[n][n];
		preferences = new HashMap<>();

		for (int i = 0; i < n * n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			students[i] = student;
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			preferences.put(student, set);
		} // 입력 끝

		for (int i = 0; i < n * n; i++) {
			findSeat(students[i]);
		}

		System.out.println(calcSum());
	}

	static void findSeat(int student) {
		Seat seat = null;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (seats[i][j] > 0) // 이미 앉은 자리
					continue;

				Seat cur = new Seat(i, j, findPrefer(student, i, j), findEmpty(i, j)); // 비교할 좌석

				if (seat == null)
					seat = cur;

				if (seat.compareTo(cur) > 0) {
					seat = cur;
				}
			}
		}

		seats[seat.r][seat.c] = student;
	}

	static int findPrefer(int student, int r, int c) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;

			if (preferences.get(student).contains(seats[nr][nc]))
				cnt++;
		}

		return cnt;
	}

	static int findEmpty(int r, int c) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;

			if (seats[nr][nc] == 0)
				cnt++;
		}

		return cnt;
	}

	static int calcSum() {
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += Math.pow(10, findPrefer(seats[i][j], i, j) - 1);
			}
		}

		return ans;
	}
}
