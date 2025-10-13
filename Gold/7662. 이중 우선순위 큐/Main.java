import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
			map = new HashMap<>();

			int k = Integer.parseInt(br.readLine());

			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (s.equals("I")) {
					maxPq.offer(n);
					minPq.offer(n);
					if (map.containsKey(n))
						map.put(n, map.get(n) + 1);
					else
						map.put(n, 1);
				} else {
					if (map.size() == 0)
						continue;
					if (n == -1) {
						remove(minPq);
					} else {
						remove(maxPq);
					}
				}
			}

			if (map.size() == 0)
				sb.append("EMPTY\n");
			else if (map.size() == 1) {
				int output = remove(maxPq);
				sb.append(output).append(" ").append(output).append("\n");
			} else {
				sb.append(remove(maxPq)).append(" ").append(remove(minPq)).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int remove(PriorityQueue<Integer> pq) {
		while (true) {
			int n = pq.poll();
			int cnt = map.getOrDefault(n, 0);

			if (cnt == 0)
				continue;

			if (cnt == 1)
				map.remove(n);
			else
				map.put(n, map.get(n) - 1);

			return n;
		}
	}
}
