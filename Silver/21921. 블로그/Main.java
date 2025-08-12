import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] visitor = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[n - x + 1];
		int ans = 0;
		for (int i = 0; i < x; i++) {
			sum[0] += visitor[i];
		}
		ans = sum[0];

		for (int i = 0; i < n - x; i++) {
			sum[i + 1] = sum[i] - visitor[i] + visitor[i + x];
			ans = Math.max(sum[i + 1], ans);
		}

		int cnt = 0;
		for (int i : sum) {
			if (i == ans)
				cnt++;
		}

		StringBuilder sb = new StringBuilder();
		if (ans == 0)
			sb.append("SAD");
		else
			sb.append(ans).append("\n").append(cnt);
		System.out.println(sb);
	}
}
