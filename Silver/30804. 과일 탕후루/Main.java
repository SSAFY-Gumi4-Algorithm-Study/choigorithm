import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		int ans = 0, left = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int right = 0; right < n; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

			while (map.size() > 2) {
				// 왼쪽 과일 제거
				map.put(arr[left], map.get(arr[left]) - 1);
				if (map.get(arr[left]) == 0) {
					map.remove(arr[left]);
				}

				left++;
			}

			ans = Math.max(ans, right - left + 1);
		}

		System.out.println(ans);
	}
}
