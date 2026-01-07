import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) != str2.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        for (int i = n, j = m; i > 0 && j > 0; ) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                stack.push(str1.charAt(i - 1));
                i--;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][m]).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
