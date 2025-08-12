import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] tem = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tem[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0, ans = 0;
		for (int i = 0; i < k; i++) {
			sum += tem[i];
		}
		ans = sum;

		for (int i = 0; i < n - k; i++) {
			sum -= tem[i];
			sum += tem[i + k];

			ans = Math.max(sum, ans);
		}

		System.out.println(ans);
	}
}
