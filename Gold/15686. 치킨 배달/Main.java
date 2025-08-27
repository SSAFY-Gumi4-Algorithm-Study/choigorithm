import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] dist;
	static boolean[] selected;
	static List<Pair> house, chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String input = st.nextToken();
				if (input.equals("1")) {
					house.add(new Pair(i, j));
				} else if (input.equals("2")) {
					chicken.add(new Pair(i, j));
				}
			}
		}

		dist = new int[house.size()][chicken.size()];
		selected = new boolean[chicken.size()];

		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chicken.size(); j++) {
				dist[i][j] = calcDist(house.get(i), chicken.get(j));
			}
		}

		dfs(0, 0);

		System.out.println(ans);
	}

	static int calcDist(Pair p1, Pair p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}

	static void dfs(int start, int cnt) {
		if (cnt == m) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int chickenDist = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (selected[j]) {
						chickenDist = Math.min(chickenDist, dist[i][j]);
					}
				}
				sum += chickenDist;
			}
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (selected[i])
				continue;

			selected[i] = true;
			dfs(i + 1, cnt + 1);
			selected[i] = false;
		}
	}
}
