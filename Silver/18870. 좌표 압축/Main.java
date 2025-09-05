import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sorted = arr.clone();
		Arrays.sort(sorted);

		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(sorted[i]))
				map.put(sorted[i], rank++);
		}

		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}
}
