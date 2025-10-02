import java.io.*;

public class Main {
    static int n, ans = 0;
    static boolean[] col, slash, bslash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new boolean[n];           // c
        slash = new boolean[2 * n - 1]; // r + c
        bslash = new boolean[2 * n];    // r - c + n

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int r) {
        if (r == n) {
            ++ans;
            return;
        }

        // 열 고르기
        for (int c = 0; c < n; c++) {
            int sum = r + c;
            int diff = r - c + n;

            if (col[c] || slash[sum] || bslash[diff]) // 같은 열, 대각선선에 존재
                continue;

            col[c] = slash[sum] = bslash[diff] = true;
            dfs(r + 1);
            col[c] = slash[sum] = bslash[diff] = false;
        }
    }
}
