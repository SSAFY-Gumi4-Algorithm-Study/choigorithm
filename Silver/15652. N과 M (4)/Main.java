import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    //static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int idx, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
