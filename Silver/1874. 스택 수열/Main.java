import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int cnt = 1;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 해당 수까지 push
			while (cnt <= num) {
				stack.push(cnt++);
				sb.append("+").append("\n");
			}
			
			if (stack.peek() != num) {
				sb = new StringBuilder().append("NO").append("\n");
				break;
			} else {
				stack.pop();
				sb.append("-").append("\n");
			}
		}
		
		// 출력
		System.out.println(sb);
	}
}
