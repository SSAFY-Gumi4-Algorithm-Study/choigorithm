import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static List<Integer>[] list;
	static Queue<Integer> q;
	static int[] inD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		q = new LinkedList<>();
		inD = new int[n + 1];
		

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			inD[b]++;
		}
		
		for (int i = 1; i <= n; i++) {
			if (inD[i] == 0)
				q.add(i);
		}
		
		bfs();
	}

	static void bfs() {
		StringBuilder sb = new StringBuilder();
		
		while (!q.isEmpty()) {
			int node = q.poll();
			sb.append(node).append(" ");
			
			for (int i: list[node]) {
				if (--inD[i] == 0) {
					q.add(i);
				}
			}
		}
		
		System.out.println(sb);
	}

}
