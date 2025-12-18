import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        // A = [[1,1],[1,0]] 를 n제곱
        // 그 결과의 [0][1], [1][0]이 F(n)
        long[][] a = {{1, 1}, {1, 0}};
        System.out.println(pow(a, n)[0][1]);
    }

    static long[][] pow(long[][] a, long n) {   // 분할 정복
        if (n == 1) return a;

        long[][] half = pow(a, n / 2);
        long[][] result = mul(half, half);

        if (n % 2 == 1) {
            return mul(a, result);
        } else {
            return result;
        }
    }

    static long[][] mul(long[][] a, long[][] b) {   // 행렬 곱셈
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= mod;
                }
            }
        }
        return result;
    }
}
