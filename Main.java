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

        void use() {
            use--;
            robot = true;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Pair> belt = new ArrayList<>();
        int first = 0; // 가장 먼저 올라간 로봇 인덱스
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int use = Integer.parseInt(st.nextToken());
            belt.add(new Pair(use, false));
        }

        // 연산
        while (true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            ans += pharse1(n, belt);

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            // 만약 이동할 수 없다면 가만히 있는다.
            // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            ans += pharse2(n, belt, first);

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            ans += pharse3(belt);

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if (checkUse(n, k, belt)) {
                System.out.print(ans);
                break;
            }
        }
    }

    static int pharse1(int n, List<Pair> belt) {
        Pair temp = belt.get(2 * n - 1);
        for (int i = 0; i < 2 * n - 1; i++) {
            belt.set(i + 1, belt.get(i));
        }
        belt.set(0, temp);
        return 1;
    }

    static int pharse2(int n, List<Pair> belt, int first) {
        Pair temp = belt.get(2 * n - 1);
        for (int i = first; i < 2 * n - 1; i++) {
            if (belt.get(i + 1).robot == true || belt.get(i + 1).use < 1) { // 이동 불가
                continue;
            }
            if (i == first) {
                first = i + 1;
            }
            belt.get(i).robot = false;
            belt.get(i + 1).use();
        }
        if ((belt.get(0).robot == false || belt.get(0).use > 0)) {
            temp.robot = false;
            belt.get(0).use();
        }
        return 1;
    }
    
    static int pharse3(List<Pair> belt) {
        if (belt.get(0).use > 0) {
            belt.get(0).use();
        }
        return 1;
    }

    // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
    static boolean checkUse(int n, int k, List<Pair> belt) {
        int cnt = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (belt.get(i).use == 0) {
                cnt++;
            }
        }
        
        if (cnt >= k)
            return true;
        return false;
    }
}
