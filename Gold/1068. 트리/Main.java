import java.util.*;
import java.io.*;

public class Main {
	static int n, ans, removed;
	static List<Integer>[] child;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		child = new ArrayList[n];
		visited = new boolean[n];
		ans = 0;

		for (int i = 0; i < n; i++) {
			child[i] = new ArrayList<>();
		}

		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
			} else {
				child[parent].add(i);
			}
		}

		removed = Integer.parseInt(br.readLine());
		// 입력 끝

		if (root == removed) {
			System.out.println(0);
			return;
		}

		delete();

		dfs(root);

		System.out.println(ans);
	}

	static void delete() {
		for (int next : child[removed]) {
			child[next] = new ArrayList<>();
		}
		child[removed] = new ArrayList<>();
	}

	static void dfs(int idx) {
		if (child[idx].size() == 0 || child[idx].size() == 1 && child[idx].get(0) == removed) {
			ans++;
			return;
		}

		visited[idx] = true;

		for (int next : child[idx]) {
			if (next == removed || visited[next])
				continue;
			dfs(next);
		}
	}
}
