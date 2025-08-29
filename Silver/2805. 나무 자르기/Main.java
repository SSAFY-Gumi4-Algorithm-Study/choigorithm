import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long left = 0;
		long right = 0;

		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (long i : arr) {
				long cut = i - mid;
				if (cut > 0)
					sum += cut;
			}

			if (sum >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}
