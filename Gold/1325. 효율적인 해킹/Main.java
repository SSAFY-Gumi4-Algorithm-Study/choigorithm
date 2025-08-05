import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adj;
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	// 컴퓨터 수
		int m = Integer.parseInt(st.nextToken());	// 신뢰 관계 수
		adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj.get(b - 1).add(a - 1);
		}
		
		// 연산
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i);
			for (int j = 0; j < n; j++) {
				if (visited[j])
					cnt[i]++;
			}
			
		}
		
		int max = Arrays.stream(cnt).max().getAsInt();

    		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (cnt[i] == max)
				sb.append(i + 1).append(" ");
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		
		for (int i: adj.get(idx)) {
			if (!visited[i])
				dfs(i);
		}
	}
}
