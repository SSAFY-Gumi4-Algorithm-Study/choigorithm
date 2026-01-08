import java.util.*;
import java.io.*;

public class Main {
    static int n, w;
    static int[] building;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            building = new int[n + 1];
            indegree = new int[n + 1];
            graph = new ArrayList[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                building[i] = Integer.parseInt(st.nextToken());
            }

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // X → Y
                indegree[y]++;
                graph[x].add(y);
            }

            w = Integer.parseInt(br.readLine());
            // 입력 끝

            sb.append(topologicalSort()).append("\n");
        }

        System.out.println(sb);
    }

    static int topologicalSort() {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = building[i];
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + building[next]);
                indegree[next]--;

                if (indegree[next] > 0)
                    continue;

                if (next == w)
                    return dp[w];
                q.add(next);
            }
        }
        return dp[w];
    }
}
