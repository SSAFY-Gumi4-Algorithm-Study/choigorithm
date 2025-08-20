import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		System.out.println(bfs(p1, p2));
	}

	static int bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[n + 1];
		Arrays.fill(visited, -1);

		visited[x] = 0;
		q.add(x);

		while (!q.isEmpty()) {
			x = q.poll();

			for (int next : list[x]) {
				if (visited[next] != -1)
					continue;

				visited[next] = visited[x] + 1;
				q.add(next);

				if (next == y) {
					break;
				}
			}
		}

		return visited[y];
	}
}
