import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		divide(0, 0, n);

		System.out.print(sb);
	}

	static void divide(int r, int c, int size) {
		int dot = arr[r][c];
		boolean allSame = true;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != dot) {
					allSame = false;
				}
			}
		}

		if (allSame) {
			sb.append(dot);
			return;
		}

		size /= 2;
		sb.append("(");
		divide(r, c, size);
		divide(r, c + size, size);
		divide(r + size, c, size);
		divide(r + size, c + size, size);
		sb.append(")");
	}
}
