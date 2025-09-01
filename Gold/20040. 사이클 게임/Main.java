import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int a, b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static int[] parent;
	static List<Edge> edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		int ans = 0;

		Arrays.fill(parent, -1);

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Edge edge = new Edge(a, b);
			ans++;

			if (!union(edge.a, edge.b)) {
				System.out.println(ans);
				return;
			}
		}

		System.out.println(0);
	}

	static int find(int node) {
		if (parent[node] < 0)
			return node;

		return parent[node] = find(parent[node]);
	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa == pb)
			return false;

		if (pa <= pb) {
			parent[pa] += parent[pb];
			parent[pb] = pa;
		} else {
			parent[pb] += parent[pa];
			parent[pa] = pb;
		}

		return true;
	}
}
