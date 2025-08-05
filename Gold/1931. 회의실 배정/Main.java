import java.util.*;
import java.io.*;

class Pair {
	int start;
	int end;
	
	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 회의 수
		List<Pair> list = new ArrayList<>();	// 회의 정보
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Pair(start, end));
		}

		list.sort(Comparator.comparingInt((Pair p) -> p.end)
							.thenComparingInt(p -> p.start));
		
		int endTime = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (list.get(i).start >= endTime) {
				endTime = list.get(i).end;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
