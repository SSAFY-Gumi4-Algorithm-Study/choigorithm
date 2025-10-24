import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		char left, right;

		Node(char left, char right) {
			this.left = left;
			this.right = right;
		}
	}

	static Node[] tree = new Node[26];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[root - 'A'] = new Node(left, right);
		} // 입력 끝

		preorder('A');
		sb.append('\n');
		inorder('A');
		sb.append('\n');
		postorder('A');

		System.out.println(sb);
	}

	static void preorder(char node) {
		if (node == '.')
			return;
		sb.append(node);
		preorder(tree[node - 'A'].left);
		preorder(tree[node - 'A'].right);
	}

	static void inorder(char node) {
		if (node == '.')
			return;
		inorder(tree[node - 'A'].left);
		sb.append(node);
		inorder(tree[node - 'A'].right);
	}

	static void postorder(char node) {
		if (node == '.')
			return;
		postorder(tree[node - 'A'].left);
		postorder(tree[node - 'A'].right);
		sb.append(node);
	}
}
