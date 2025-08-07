import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		// 연산
		visited[1] = true; // 본인 방문처리
		dfs(1, 0);

		// 출력
		int ans = 0;
		for (boolean b : visited) {
			if (b)
				ans++;
		}
		System.out.println(ans - 1); // 본인 제외
	}

	static void dfs(int idx, int depth) {
		if (depth == 2) // 친구의 친구까지만
			return;

		for (int i : list[idx]) {
			visited[i] = true;
			dfs(i, depth + 1);
		}
	}
}
