import java.util.*;
import java.io.*;

public class Main {
	static int n, m, b;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		int min = Integer.MAX_VALUE, max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int height = 0, minTime = Integer.MAX_VALUE;
		for (int i = min; i <= max; i++) {
			int time = solution(i);
			if (time <= minTime) {
				height = i;
				minTime = time;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(minTime).append(" ").append(height);
		System.out.println(sb);
	}

	static int solution(int height) {
		int time = 0, need = 0, inven = b;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] < height) {
					int diff = height - map[i][j];
					time += diff;
					need += diff;
				} else {
					int diff = map[i][j] - height;
					time += diff * 2;
					inven += diff;
				}
			}
		}

		if (inven < need)
			return Integer.MAX_VALUE;
		return time;
	}
}
