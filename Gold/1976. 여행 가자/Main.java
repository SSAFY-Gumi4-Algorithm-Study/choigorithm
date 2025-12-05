import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];

        int m = Integer.parseInt(br.readLine());
        int[] plan = new int[m];

        for (int i = 0; i < n; i++) {
            graph[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int connect = Integer.parseInt(st.nextToken());
                if (connect == 1)
                    graph[i][j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }   // 입력 끝

        floydWarshall();

        for (int i = 0; i < m - 1; i++) {
            if (!graph[plan[i]][plan[i + 1]]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] && graph[k][j])
                        graph[i][j] = true;
                }
            }
        }
    }
}
