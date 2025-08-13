import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] maxDp = new int[n][3];
		int[][] minDp = new int[n][3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			maxDp[0][i] = minDp[0][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			int[] arr = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			maxDp[i + 1][0] = Math.max(maxDp[i][0], maxDp[i][1]) + arr[0];
			maxDp[i + 1][1] = Math.max(maxDp[i][0], Math.max(maxDp[i][1], maxDp[i][2])) + arr[1];
			maxDp[i + 1][2] = Math.max(maxDp[i][1], maxDp[i][2]) + arr[2];

			minDp[i + 1][0] = Math.min(minDp[i][0], minDp[i][1]) + arr[0];
			minDp[i + 1][1] = Math.min(minDp[i][0], Math.min(minDp[i][1], minDp[i][2])) + arr[1];
			minDp[i + 1][2] = Math.min(minDp[i][1], minDp[i][2]) + arr[2];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2]))).append(" ")
				.append(Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2])));
		System.out.println(sb);
	}
}
