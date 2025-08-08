import java.util.*;
import java.io.*;

class Main {
	static int[][] arr;
	static int white, blue;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, n);

		StringBuilder sb = new StringBuilder();
		sb.append(white).append("\n").append(blue);
		System.out.println(sb);
	}

	static void divide(int row, int col, int size) {
		// 색상 다 같은지 확인
		int color = arr[row][col];
		boolean flag = true;

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != color) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			if (color == 0)
				white++;
			else
				blue++;
			return;
		}

		size /= 2;
		divide(row, col, size);
		divide(row + size, col, size);
		divide(row, col + size, size);
		divide(row + size, col + size, size);
	}
}
