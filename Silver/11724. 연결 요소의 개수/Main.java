import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] adj;
	static boolean visited[];
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				ans += dfs(i);
		}
		
		System.out.println(ans);
	}

	static int dfs(int idx) {
		visited[idx] = true;
		
		for (int i: adj[idx]) {
			if (!visited[i])
				dfs(i);
		}
		
		return 1;
	}
}
