import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();    // 입력 끝

        int bombLen = bomb.length;
        char[] stack = new char[str.length];
        int top = 0;

        for (char c: str) {
            stack[top++] = c;

            if (top >= bombLen && c == bomb[bombLen - 1]) {
                boolean same = true;
                for (int i = 0; i < bombLen; i++) {
                    if (stack[top - bombLen + i] != bomb[i]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    top -= bombLen;
                }
            }
        }

        if (top == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(new String(stack, 0, top));
        }
    }
}
