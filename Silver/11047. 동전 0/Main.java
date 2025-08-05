import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = n - 1; i >= 0; i--) {
			if (k == 0)
				break;
			if (arr[i] > k)
				continue;
			ans += k / arr[i];
			k -= k / arr[i] * arr[i];
		}
		
		System.out.println(ans);
	}
}
