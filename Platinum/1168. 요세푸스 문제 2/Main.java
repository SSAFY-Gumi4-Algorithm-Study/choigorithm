import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int idx = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < n - 1; i++) {
			idx += k;

			if (idx >= list.size()) {
				idx %= list.size();
			}

			sb.append(list.remove(idx) + ", ");
		}
		sb.append(list.remove(0) + ">");

		System.out.println(sb);
	}
}
