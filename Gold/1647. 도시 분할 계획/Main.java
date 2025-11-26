import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int n1, n2, w;

        public Edge(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }

    static int[] parent;
    static Edge[] edgeList;

    static int find(int x) {
        if (parent[x] < 0)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (parent[pa] < parent[pb]) {
            parent[pa] += parent[pb];
            parent[pb] = pa;
        } else {
            parent[pb] += parent[pa];
            parent[pa] = pb;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        edgeList = new Edge[e];

        Arrays.fill(parent, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(n1, n2, w));
        }

        int cnt = 0, ans = 0, max = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!union(edge.n1, edge.n2))
                continue;
            ans += edge.w;
            max = edge.w;
            if (++cnt == v - 1)
                break;
        }

        System.out.println(ans - max);
    }
}
