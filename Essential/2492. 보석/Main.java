import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Point[] gems = new Point[t];
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			gems[i] = new Point(x, y);
		}

		int maxCount = 0;
		Point ans = null;

		// 모든 금강석을 정사각형의 오른쪽 위 모서리로 정해서, 해당 정사각형에서 포함되는 개수 세기
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				int rightX = gems[i].x;
				int rightY = gems[j].y;

				// 이 정사각형 안에서 금강석 개수 구하기
				int cnt = 0;
				for (int l = 0; l < t; l++) {
					int x = gems[l].x;
					int y = gems[l].y;

					if (rightX - k < 0) {
						rightX = k;
					}

					if (rightY - k < 0) {
						rightY = k;
					}

					if (rightX - k <= x && x <= rightX && rightY - k <= y && y <= rightY) {
						cnt++;
					}
				}

				if (cnt >= maxCount) {
					maxCount = cnt;
					ans = new Point(rightX - k, rightY); // 왼쪽 위 좌표 저장
				}
			}
		}

		System.out.println(ans.x + " " + ans.y);
		System.out.println(maxCount);
	}
}
