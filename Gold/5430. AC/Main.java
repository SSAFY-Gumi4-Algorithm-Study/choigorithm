import java.util.*;
import java.io.*;

public class Main {

	static String p, arrString;
	static Deque<String> dq;
	static boolean reverse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			p = br.readLine(); // 함수
			int n = Integer.parseInt(br.readLine()); // 배열 크기
			arrString = br.readLine(); // 배열
			// 입력 끝

			if (ac()) {
				sb.append("[");
				while (!dq.isEmpty()) {
					sb.append(reverse ? dq.pollLast() : dq.pollFirst());
					if (dq.isEmpty())
						break;
					else
						sb.append(",");
				}
				sb.append("]\n");
			} else
				sb.append("error\n");
		}

		System.out.println(sb);
	}

	static boolean ac() {
		String[] arr = arrString.substring(1, arrString.length() - 1).split(",");
		dq = new ArrayDeque<>();

		// Array -> Deque
		for (String s : arr) {
			if (!s.equals(""))
				dq.add(s);
		}

		reverse = false;
		char[] cmdArr = p.toCharArray();
		for (char cmd : cmdArr) {
			if (cmd == 'R') {
				reverse = !reverse;
			}
			if (cmd == 'D') {
				if (dq.isEmpty()) {
					return false;
				}
				if (reverse) {
					dq.pollLast();
				} else {
					dq.pollFirst();
				}
			}
		}

		return true;
	}
}
