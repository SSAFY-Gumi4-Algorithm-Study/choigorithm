import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			long ans = 1;
			for (int i = 1; i <= n; i++) {
				ans = ans * (m - i + 1) / i;
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
