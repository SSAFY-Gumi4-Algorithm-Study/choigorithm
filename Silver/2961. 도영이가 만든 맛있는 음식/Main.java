import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] s;	// 신맛
	static int[] b;	// 쓴맛
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 1, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int idx, int mul, int sum) {
		if (idx != 0) {
			ans = Math.min(ans, Math.abs(mul - sum));
		}
		
		for (int i = idx; i < n; i++) {
			dfs(i + 1, mul * s[i], sum + b[i]);
		}
	}
}
