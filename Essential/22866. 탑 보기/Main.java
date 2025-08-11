import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 건물 개수
		// 건물 높이, 가장 가까운 건물 거리, 볼 수 있는 건물 개수
		int[] h = new int[n + 1], dist = new int[n + 1], cnt = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			dist[i] = 100001;
		}

		// left
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			while (!stack.isEmpty() && h[stack.peek()] <= h[i]) { // 현재 건물보다 작거나 같음
				stack.pop();
			}
			cnt[i] = stack.size();
			if (cnt[i] > 0)
				dist[i] = stack.peek();
			stack.push(i);
		}

		// right
		stack = new Stack<>();
		for (int i = n; i > 0; i--) {
			while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
				stack.pop();
			}
			int s = stack.size();
			cnt[i] += s;
			if (s > 0 && Math.abs(stack.peek() - i) < Math.abs(dist[i] - i)) // left 건물과 거리 비교
				dist[i] = stack.peek();
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(cnt[i]);
			if (cnt[i] != 0)
				sb.append(" ").append(dist[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
