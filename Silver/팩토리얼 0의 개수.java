import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        while (n >= 5) {
            ans += (n /= 5);
        }

        System.out.println(sb);
    }
}
