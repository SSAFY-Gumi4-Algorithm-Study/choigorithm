import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		bfs(n, k);
	}

	static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[100001];
		int cnt = 0;

		q.add(n);
		visited[n] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < 3; i++) {
				int next = calc(i, x);

				if (next < 0 || next > 100000)
					continue;

				if (visited[next] != 0 && visited[next] < visited[x] + 1)
					continue;

				visited[next] = visited[x] + 1;

				if (next == k) {
					cnt++;
					continue;
				}

				q.add(next);
			}
		}

		System.out.println(visited[k] - 1);
		System.out.println(cnt);
	}

	static int calc(int i, int x) {
		if (i == 0)
			return x - 1;
		else if (i == 1)
			return x + 1;
		else
			return x * 2;
	}
}
