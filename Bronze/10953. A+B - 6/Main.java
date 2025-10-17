import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] nums = br.readLine().split(",");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);

			sb.append(a + b).append("\n");
		}

		System.out.println(sb);
	}
}
