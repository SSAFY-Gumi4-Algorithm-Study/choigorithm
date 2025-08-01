import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int ans = 0;

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            // 연산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        ans++;
                        dfs(n, m, arr, i, j);
                    }
                }
            }

            // 출력
            System.out.println(ans);
        }
    }

    static void dfs(int n, int m, int[][] arr, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || arr[r][c] == 0) {
            return;
        }

        arr[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            dfs(n, m, arr, nr, nc);
        }
    }
}
