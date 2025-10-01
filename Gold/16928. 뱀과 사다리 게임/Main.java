import java.util.*;
import java.io.*;

public class Main {
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 사다리
		int m = Integer.parseInt(st.nextToken()); // 뱀

		map = new int[101];

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
		} // 입력 끝

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] dist = new int[101];

		Arrays.fill(dist, -1);

		q.offer(1);
		dist[1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= 6; i++) {
				int npos = cur + i;
				if (npos > 100)
					break;

				if (map[npos] != 0) {
					npos = map[npos];
				}

				if (dist[npos] != -1)
					continue;

				dist[npos] = dist[cur] + 1;

				if (npos == 100) {
					return dist[npos];
				}

				q.offer(npos);
			}
		}
		return dist[100];
	}
}
