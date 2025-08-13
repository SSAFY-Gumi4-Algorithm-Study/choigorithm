import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = 0;
	static int[] s, w;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		w = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}

		bt(0);

		System.out.println(ans);
	}

	static void bt(int idx) {
		if (idx == n) {
			int cnt = 0;
			for (int i : s) {
				if (i <= 0)
					cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}

		if (s[idx] < 0) {
			bt(idx + 1);
			return;
		}

		boolean hit = false;
		for (int i = 0; i < n; i++) {
			if (i == idx || s[i] < 0)
				continue;

			hit = true;
			hit(idx, i);
			bt(idx + 1);
			reset(idx, i);
		}

		if (!hit)
			bt(idx + 1);
	}

	static void hit(int egg1, int egg2) {
		s[egg1] -= w[egg2];
		s[egg2] -= w[egg1];
	}

	static void reset(int egg1, int egg2) {
		s[egg1] += w[egg2];
		s[egg2] += w[egg1];
	}
}
