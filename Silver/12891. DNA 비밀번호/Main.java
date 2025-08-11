import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // 임의 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 만들 부분 문자열 길이
		String dna = br.readLine(); // 임의 문자열
		int[] acgt = new int[4]; // 최소 개수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}

		int cnt[] = new int[4]; // acgt 개수 카운트
		for (int i = 0; i < p; i++) {
			cnt[mappingNum(dna.charAt(i))]++;
		}

		int ans = 0;
		for (int i = 0; i <= s - p; i++) {
			boolean flag = true;

			for (int j = 0; j < 4; j++) {
				if (cnt[j] < acgt[j]) {
					flag = false;
					break;
				}
			}

			if (flag)
				ans++;

			if (i == s - p)
				break;

			cnt[mappingNum(dna.charAt(i))]--;
			cnt[mappingNum(dna.charAt(i + p))]++;
		}

		System.out.println(ans);
	}

	static int mappingNum(char c) {
		if (c == 'A')
			return 0;
		if (c == 'C')
			return 1;
		if (c == 'G')
			return 2;
		if (c == 'T')
			return 3;
		return -1;
	}
}
