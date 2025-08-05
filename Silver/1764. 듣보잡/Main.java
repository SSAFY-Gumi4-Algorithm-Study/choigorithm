import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				list.add(s);
				ans++;
			}
		}
		list.sort(Comparator.comparing(s -> s));

		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
