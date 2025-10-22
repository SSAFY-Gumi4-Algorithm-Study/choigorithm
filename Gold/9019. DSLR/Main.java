import java.util.*;
import java.io.*;

public class Main {
	static class Register {
		int n;
		String command;

		public Register(int n, String command) {
			this.n = n;
			this.command = command;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(bfs(a, b));
		}
	}

	static String bfs(int initial, int result) {
		Queue<Register> q = new ArrayDeque<>();
		boolean[] visited = new boolean[10000];
		char[] c = { 'D', 'S', 'L', 'R' };

		q.offer(new Register(initial, ""));
		visited[initial] = true;

		while (!q.isEmpty()) {
			Register cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int next;
				if (i == 0)
					next = d(cur.n);
				else if (i == 1)
					next = s(cur.n);
				else if (i == 2)
					next = l(cur.n);
				else
					next = r(cur.n);

				if (next == result)
					return cur.command + c[i];

				if (!visited[next]) {
					q.offer(new Register(next, cur.command + c[i]));
					visited[next] = true;
				}
			}
		}

		return "";
	}

	static int d(int n) {
		return n * 2 % 10000;
	}

	static int s(int n) {
		return n == 0 ? 9999 : n - 1;
	}

	static int l(int n) {
		return n % 1000 * 10 + n / 1000;
	}

	static int r(int n) {
		return n % 10 * 1000 + n / 10;
	}
}
