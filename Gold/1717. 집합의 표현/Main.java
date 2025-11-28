import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        Arrays.fill(parent, -1);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 입력 끝

            if (op == 0) {
                union(a, b);
                continue;
            }

            sb.append(find(a) == find(b) ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] < 0)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (parent[pa] <= parent[pb]) {
            parent[pa] += parent[pb];
            parent[pb] = pa;
        } else {
            parent[pb] += parent[pa];
            parent[pa] = pb;
        }
    }
}
