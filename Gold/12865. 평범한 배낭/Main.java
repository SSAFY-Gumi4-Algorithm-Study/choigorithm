import java.util.*;
import java.io.*;

public class Main {
	static class Item {
		int w, v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Item[] items = new Item[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = k; j >= items[i].w; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i].w] + items[i].v);
			}
		}

		System.out.println(dp[k]);
	}
}
