import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   // 입력 끝

        int lis = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lis) {
                stack.push(arr[i]);
                lis--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
