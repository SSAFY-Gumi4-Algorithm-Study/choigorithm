import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			long[] h = new long[n + 2];
			for (int i = 1; i <= n; i++) {
				h[i] = Long.parseLong(st.nextToken());
			} // 입력 끝

			Stack<Integer> stack = new Stack<>();
			long ans = 0;
			stack.push(0);
			for (int i = 1; i <= n + 1; i++) {
				while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
					ans = Math.max(ans, h[stack.pop()] * (i - 1 - stack.peek()));
				}
				stack.push(i);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
