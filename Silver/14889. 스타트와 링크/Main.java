import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = Integer.MAX_VALUE;
	static int s[][];
	static boolean team[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		team = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(ans);
	}

	static void dfs(int idx, int cnt) {
		if (cnt == n / 2) {
			List<Integer> start = new ArrayList<>();
			List<Integer> link = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (team[i])
					start.add(i);
				else
					link.add(i);
			}
			ans = Math.min(ans, calc(start, link));
			return;
		}

		for (int i = idx; i < n; i++) {
			if (team[i] != true) {
				team[i] = true;
				dfs(i, cnt + 1);
				team[i] = false;
			}
		}
	}

	static int calc(List<Integer> start, List<Integer> link) {
		int sSum = 0, lSum = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				sSum += s[start.get(i)][start.get(j)];
				lSum += s[link.get(i)][link.get(j)];
			}
		}

		return Math.abs(sSum - lSum);
	}
}
