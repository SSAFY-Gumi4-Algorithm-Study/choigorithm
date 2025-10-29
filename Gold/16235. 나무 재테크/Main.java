import java.util.*;
import java.io.*;

public class Main {
	static class Tree {
		int r, c, age;
		boolean dead;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.dead = false;
		}
	}

	static int n;
	static List<Tree> tree = new ArrayList<>();
	static Queue<Tree> dead = new ArrayDeque<>();
	static int[][] map; // 현재 양분
	static int[][] a; // 겨울에 주는 양분
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = 5;
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			tree.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		} // 입력 끝

		while (k-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(tree.size());
	}

	static void spring() {
		tree.sort((t1, t2) -> Integer.compare(t1.age, t2.age));

		for (Tree cur : tree) {
			if (map[cur.r][cur.c] - cur.age < 0) { // 양분 없음
				dead.add(cur);
				cur.dead = true;
				continue;
			}

			map[cur.r][cur.c] -= cur.age;
			cur.age++;
		}
	}

	static void summer() {
		while (!dead.isEmpty()) {
			Tree cur = dead.poll();

			map[cur.r][cur.c] += cur.age / 2;
		}
	}

	static void fall() { // 죽은 나무 삭제 & 새 나무 넣기
		List<Tree> newTree = new ArrayList<>();
		for (Tree cur : tree) {
			if (cur.dead)
				continue;

			newTree.add(cur);

			if (cur.age % 5 != 0)
				continue;

			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;

				newTree.add(new Tree(nr, nc, 1));
			}
		}

		tree = newTree;
	}

	static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] += a[i][j];
			}
		}
	}
}
