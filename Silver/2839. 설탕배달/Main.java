import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 1. 5로 나누어떨어짐: 5로만 채움
		// 2. 5 채운 후 나머지 1 -> 5 빼고 3x2 채우기
		// 					2 -> 5x2 빼고 3x4 채우기
		// 					3 -> 3 채우기
		// 					4 -> 5 빼고 3x3 채우기
		// 4, 7은 -1

		if (n == 4 || n == 7)
			System.out.println(-1);
		else if (n % 5 == 0)
			System.out.println(n / 5);
		else if (n % 5 == 1 || n % 5 == 3)
			System.out.println(n / 5 + 1);
		else if (n % 5 == 2 || n % 5 == 4)
			System.out.println(n / 5 + 2);
	}
}
