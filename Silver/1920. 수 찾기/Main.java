import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			if (binary_search(Integer.parseInt(st.nextToken())))
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}

		System.out.println(sb);
	}

	static boolean binary_search(int num) {
		int l = 0;
		int r = arr.length - 1;
		int mid = arr.length / 2;

		while (l <= r) {
			if (arr[mid] == num) {
				return true;
			}

			if (num > arr[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
			mid = (l + r) / 2;

		}
		return false;
	}
}
