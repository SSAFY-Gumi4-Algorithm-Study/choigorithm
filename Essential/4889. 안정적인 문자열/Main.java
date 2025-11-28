import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            String str = br.readLine();
            if (str.contains("-"))
                break;

            int ans = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    stack.push('{');
                } else {
                    if (stack.isEmpty()) {
                        ans++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(tc++).append(". ").append(ans + stack.size() / 2).append("\n");
        }

        System.out.println(sb);
    }
}
