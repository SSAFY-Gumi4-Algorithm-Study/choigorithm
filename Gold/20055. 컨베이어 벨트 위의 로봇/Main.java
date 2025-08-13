import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int use;
		boolean robot;

		Pair(int use, boolean robot) {
			this.use = use;
			this.robot = robot;
		}
	}

	static int n, k, up, down; // 올리는 위치, 내리는 위치
	static List<Pair> belt;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new ArrayList<Pair>();
		up = 0;
		down = n - 1;
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			belt.add(new Pair(Integer.parseInt(st.nextToken()), false));
		}

		// 연산
		while (true) {
			phase1();
			robotDown();
			phase2();
			phase3();
			ans++;
			if (phase4())
				break;
		}

		System.out.println(ans);
	}

	// 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
	static void robotDown() {
		if (belt.get(down).robot == true)
			belt.get(down).robot = false;
	}

	// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
	static void phase1() {
		if (--up < 0)
			up = 2 * n - 1;

		if (--down < 0)
			down = 2 * n - 1;
	}

	// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히
	// 있는다.
	// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
	static void phase2() {
		int cur = down;
		while (cur != up) {
			if (--cur < 0) {
				cur = 2 * n - 1;
			}
			int next = (cur + 1) % (2 * n);
			if (belt.get(cur).robot && belt.get(next).use > 0 && !belt.get(next).robot) {
				belt.get(cur).robot = false;
				belt.get(next).use--;
				if (next != down) {
					belt.get(next).robot = true;
				}
			}
		}
	}

	// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
	static void phase3() {
		if (belt.get(up).use > 0 && !belt.get(up).robot) {
			belt.get(up).use--;
			belt.get(up).robot = true;
		}
	}

	// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
	static boolean phase4() {
		int cnt = 0;
		for (Pair p : belt) {
			if (p.use == 0)
				cnt++;
		}
		return (cnt >= k);
	}
}
