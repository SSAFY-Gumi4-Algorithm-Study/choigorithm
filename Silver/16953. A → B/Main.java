import java.util.*;
import java.io.*;

public class Main {
	static class Pair {
		int num, cnt;

		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int ans = 1;

		while (a != b) {
			if (a > b || (b % 2 != 0 && b % 10 != 1)) {
				ans = -1;
				break;
			}

			if (b % 2 == 0)
				b /= 2;
			else
				b /= 10;

			ans++;
		}

		System.out.println(ans);
	}
}
