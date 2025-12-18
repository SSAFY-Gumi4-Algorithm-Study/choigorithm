import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mod = 1000;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken()) % mod;
            }
        }   // 입력 끝

        int[][] result = pow(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] pow(int[][] a, long b) {   // 분할 정복
        if (b == 1) return a;

        int[][] half = pow(a, b / 2);
        int[][] result = mul(half, half);

        if (b % 2 == 1) {
            return mul(a, result);
        } else {
            return result;
        }
    }

    static int[][] mul(int[][] a, int[][] b) {   // 행렬 곱셈
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= mod;
            }
        }
        return result;
    }
}
