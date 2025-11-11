import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[][] parent;
    static int[] depth;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 노드 개수
        k = 0;

        int tmp = 1;
        while (tmp <= n) {
            tmp <<= 1;
            k++;
        }

        parent = new int[n + 1][k];
        depth = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        } // 입력1 끝

        dfs(1, 1); // 깊이 저장
        initParent();   // 2^k번째 조상 구하기

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        } // 입력2 & 연산

        System.out.println(sb);
    }

    static void dfs(int cur, int d) {
        depth[cur] = d;

        for (int next : tree[cur]) {
            if (depth[next] != 0)
                continue;

            dfs(next, d + 1);
            parent[next][0] = cur;
        }
    }

    static void initParent() {
        for (int i = 1; i < k; i++) {
            for (int cur = 1; cur <= n; cur++) {
                parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {  // a가 더 깊도록
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = k - 1; i >= 0; i--) {  // 깊이 맞추기. 2^k씩 올라감
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b)
            return a;

        // 공통 조상 찾기
        for (int i = k - 1; i >= 0; i--) {  // 가장 위의 조상부터 내려오면서
            if (parent[a][i] != parent[b][i]) { // 다르면 한칸 위가 최소 공통 조상
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
