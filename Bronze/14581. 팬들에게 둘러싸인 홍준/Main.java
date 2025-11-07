import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(":fan::fan::fan:\n:fan::").append(s).append("::fan:\n:fan::fan::fan:");
		System.out.println(sb);
	}
}
