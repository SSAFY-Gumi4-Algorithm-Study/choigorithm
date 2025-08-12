import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] dish = new int[n];
		int[] type = new int[d + 1];
		int ans, cnt = 0;

		for (int i = 0; i < n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < k; i++) {
			if (type[dish[i]] == 0)
				cnt++;
			type[dish[i]]++;
		}
		ans = cnt + (type[c] == 0 ? 1 : 0);

		for (int i = 1; i <= n; i++) {
			if (--type[dish[i - 1]] == 0)
				cnt--;
			if (++type[dish[(i + k - 1) % n]] == 1)
				cnt++;

			ans = Math.max(ans, cnt + (type[c] == 0 ? 1 : 0));
		}
		System.out.println(ans);
	}
}
