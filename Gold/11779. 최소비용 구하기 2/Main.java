import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int n;
    static List<Edge>[] edgeList;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수
        edgeList = new ArrayList[n + 1];
        before = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList[from].add(new Edge(to, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        // 입력 끝

        StringBuilder sb = new StringBuilder();
        sb.append(dijkstra(s, e)).append("\n");

        ArrayList<Integer> routes = new ArrayList<>();
        int cur = e;
        while (cur != 0) {
            routes.add(cur);
            cur = before[cur];
        }
        sb.append(routes.size()).append("\n");
        for (int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    static int dijkstra(int s, int e) {
        int[] dist = new int[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> p1.w - p2.w);

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.to == e)
                return dist[cur.to];

            if (dist[cur.to] < cur.w)
                continue;

            for (Edge next : edgeList[cur.to]) {
                if (dist[next.to] > cur.w + next.w) {
                    dist[next.to] = cur.w + next.w;
                    pq.add(new Edge(next.to, dist[next.to]));
                    before[next.to] = cur.to;
                }
            }
        }

        return 0;
    }
}
