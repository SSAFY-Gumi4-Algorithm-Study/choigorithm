import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			return absA == absB ? Integer.compare(a, b) : Integer.compare(absA, absB);
		});
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}

		System.out.println(sb);
	}
}
