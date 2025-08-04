import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = "";

		while (!(s = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			int i = 0;
			boolean flag = true;

			for (; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == '(' || c == '[')
					stack.push(c);

				if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						flag = false;
						break;
					}
				}

				if (c == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						flag = false;
						break;
					}
				}
			}

			if (!stack.isEmpty())
				flag = false;
			
			sb.append(flag ? "yes" : "no").append("\n");
		}
		System.out.println(sb);
	}
}
