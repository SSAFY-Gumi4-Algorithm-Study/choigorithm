import java.util.*;
import java.io.*;

public class Main {
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] operand, operator = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		operand = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		dfs(1, operand[0]);

		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	static void dfs(int cnt, int result) {
		if (cnt == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) {
				continue;
			}

			operator[i]--;

			if (i == 0) {
				dfs(cnt + 1, result + operand[cnt]);
			} else if (i == 1) {
				dfs(cnt + 1, result - operand[cnt]);
			} else if (i == 2) {
				dfs(cnt + 1, result * operand[cnt]);
			} else {
				dfs(cnt + 1, result / operand[cnt]);
			}

			operator[i]++;
		}
	}
}
