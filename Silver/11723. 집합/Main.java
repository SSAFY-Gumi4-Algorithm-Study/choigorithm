import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.equals("all")) {
				set.clear();
				for (int i = 1; i <= 20; i++) {
					set.add(i);
				}
			} else if (op.equals("empty")) {
				set.clear();
			} else if (op.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			} else if (op.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			} else if (op.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x))
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			} else if (op.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x))
					set.remove(x);
				else
					set.add(x);
			}
		}
		
		System.out.println(sb);
	}
}
