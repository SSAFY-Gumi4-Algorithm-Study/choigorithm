import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 사람 수
        int m = Integer.parseInt(st.nextToken());   // 파티 수
        st = new StringTokenizer(br.readLine());
        int truthSize = Integer.parseInt(st.nextToken());   // 진실을 아는 사람 수
        if (truthSize == 0) {
            System.out.println(m);
            return;
        }
        parent = new int[n + 1];
        truth = new int[truthSize];
        List<Integer>[] party = new ArrayList[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < truthSize; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }   // 입력 끝

        // 같은 파티 -> 같은 집합
        for (int i = 0; i < m; i++) {
            int firstP = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstP, party[i].get(j));
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int firstP = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < truthSize; j++) {
                if (find(firstP) == find(truth[j])) {   // 진실을 아는 사람과 같은 집합
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}
