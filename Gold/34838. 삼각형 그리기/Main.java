import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        System.out.print(n % 3 == 0 ?
                (n * n - 3 * n + 6) / 6 : (n - 1) * (n - 2) / 6);
    }
}
