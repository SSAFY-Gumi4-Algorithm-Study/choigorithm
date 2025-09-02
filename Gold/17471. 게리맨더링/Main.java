import java.util.*;
import java.io.*;

public class Main {

	static int n, ans = Integer.MAX_VALUE;
	static int[] people;
	static List<Integer>[] near;
	static List<Integer> a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		near = new ArrayList[n + 1];
		a = new ArrayList<>();
		b = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			near[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				near[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		// 입력 끝

		for (int i = 1; i <= n / 2; i++) {
			dfs(1, i);
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void dfs(int start, int depth) {
		if (a.size() == depth) {
			for (int i = 1; i <= n; i++) {
				if (!a.contains(i))
					b.add(i);
			}

			if (bfs(a) && bfs(b))
				ans = Math.min(ans, calc());

			b.clear();
			return;
		}

		for (int i = start; i <= n; i++) {
			a.add(i);
			dfs(i + 1, depth);
			a.remove(a.size() - 1);
		}
	}

	static boolean bfs(List<Integer> section) { // 연결 확인
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];

		q.add(section.get(0));
		visited[section.get(0)] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : near[cur]) {
				if (!section.contains(next) || visited[next])
					continue;

				q.add(next);
				visited[next] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (section.contains(i) && !visited[i])
				return false;
		}

		return true;
	}

	static int calc() { // 인구 수 차이 계산
		int aSum = 0, bSum = 0;

		for (int i : a) {
			aSum += people[i];
		}

		for (int i : b) {
			bSum += people[i];
		}

		return Math.abs(aSum - bSum);
	}

}
