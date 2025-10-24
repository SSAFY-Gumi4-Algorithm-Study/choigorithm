import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr, selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		selected = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0, 0);

		System.out.println(sb);
	}

	static void dfs(int idx, int depth) {
		if (depth == m) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = 0;
		for (int i = idx; i < n; i++) {
			if (before != arr[i]) {
				before = arr[i];
				selected[depth] = arr[i];
				dfs(i, depth + 1);
			}
		}
	}
}
