import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int r, c;
	static int[][] paper;
	static int[][] sticker;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		paper = new int[n][m];

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			sticker = new int[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			for (int i = 0; i < 4; i++) {
				if (search())
					break;
				rotate();
			}
		}

		System.out.println(calcSum());
	}

	static boolean search() { // 붙일 공간 탐색
		for (int i = 0; i <= n - r; i++) {
			for (int j = 0; j <= m - c; j++) {
				if (put(i, j))
					return true;
			}
		}

		return false;
	}

	static boolean put(int startR, int startC) { // 스티커 붙이기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] == 1 && paper[startR + i][startC + j] == 1)
					return false;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] == 1) {
					paper[startR + i][startC + j] = 1;
				}
			}
		}
		return true;
	}

	static void rotate() { // 스티커 회전
		r = sticker[0].length;
		c = sticker.length;

		int[][] newSticker = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newSticker[i][j] = sticker[c - j - 1][i];
			}
		}

		sticker = newSticker;
	}

	static int calcSum() {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1)
					sum++;
			}
		}

		return sum;
	}

}
