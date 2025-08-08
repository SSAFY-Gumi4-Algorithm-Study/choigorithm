import java.util.*;
import java.io.*;

class Main {
	static boolean found;
	static int[] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		found = false;
		arr = new int[9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0);
	}
	
	static void dfs(int idx, int remove) {
		if (remove == 2) {
			if (Arrays.stream(arr).sum() == 100) {
				found = true;
				StringBuilder sb = new StringBuilder();
				for (int i : arr) {
					if (i != 0)
						sb.append(i).append("\n");
				}
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			if (found) return;
			int temp = arr[i];
			arr[i] = 0;
			dfs(i + 1, remove + 1);
			arr[i] = temp;
		}
	}
}
