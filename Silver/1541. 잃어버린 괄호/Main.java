import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("-");

        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            String[] operand = s[i].split("\\+");
            int sum = 0;

            for (String op : operand) {
                sum += Integer.parseInt(op);
            }

            if (i == 0) ans += sum;
            else ans -= sum;
        }

        System.out.println(ans);
    }
}
