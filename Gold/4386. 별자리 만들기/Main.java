import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int n1, n2;
        double w;

        public Edge(int n1, int n2, double w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x= x;
            this.y = y;
        }
    }

    static int[] parent;

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
        int n = Integer.parseInt(st.nextToken());
        Point[] points = new Point[n];
        parent = new int[n];

        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }   // 입력 끝

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.w, e2.w));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i +1; j < n; j++) {
                pq.add(new Edge(i, j, calcDist(points[i], points[j])));
            }
        }

        int cnt = 0;
        double ans = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!union(edge.n1, edge.n2))
                continue;
            ans += edge.w;
            if (++cnt == n - 1)
                break;
        }

        System.out.println(ans);
    }

    static double calcDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
}
