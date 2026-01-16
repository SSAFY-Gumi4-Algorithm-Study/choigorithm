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

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left >= 0 && right < n && left < right) {
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                } else {
                    int sum = arr[left] + arr[right];
                    if (sum == arr[i]) {
                        ans++;
                        break;
                    }
                    if (sum < arr[i])
                        left++;
                    else
                        right--;
                }
            }
        }

        System.out.println(ans);
    }
}

// arr[left] + arr[right] == arr[i] 면 i++
// arr[left] + arr[right] < arr[i] 면 left++
// arr[left] + arr[right] > arr[i] 면 right--
