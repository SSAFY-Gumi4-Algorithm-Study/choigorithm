import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 의상 수
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				if (map.get(type) != null)
					map.replace(type, map.get(type) + 1);
				else
					map.put(type, 1);
			}

			int ans = 1;
			for (int i : map.values()) {
				ans *= i + 1;
			}
			sb.append(ans - 1).append("\n");
		}

		System.out.println(sb);
	}
}
