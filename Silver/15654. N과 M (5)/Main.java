import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   // 입력 끝

        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : selected) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                selected[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
