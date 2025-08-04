import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;

	Pair (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, y));
		}

		list.sort(
			Comparator.comparingInt((Pair p) -> p.x)
						.thenComparing(p -> p.y)
		);

		for (int i = 0; i < n; i++) {
			sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
		}

		System.out.println(sb);
	}
}
