import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   // 입력 끝

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans1).append(" ").append(ans2);
        System.out.println(sb);
    }
}
