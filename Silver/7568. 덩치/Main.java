import java.io.*;
import java.util.*;

class Pair {
	int weight;
	int height;

	Pair (int weight, int height) {
		this.weight = weight;
		this.height = height;
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
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Pair(weight, height));
		}

		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (list.get(i).weight < list.get(j).weight 
					&& list.get(i).height < list.get(j).height) {
						rank++;
					}
			}
			sb.append(rank + " ");
		}

		System.out.println(sb);
	}
}
