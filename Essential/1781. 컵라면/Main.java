import java.util.*;
import java.io.*;

public class Main {
    static class Problem {
        int deadline, reward;

        public Problem(int deadline, int reward) {
            this.deadline = deadline;
            this.reward = reward;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Problem[] problems = new Problem[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }   // 입력 끝

        // 1. 데드라인이 작은 문제부터
        // 2. 더 많은 컵라면이 있는 문제부터
        Arrays.sort(problems, (p1, p2) -> {
            if (p1.deadline == p2.deadline)
                return p2.reward - p1.reward;
            return p1.deadline - p2.deadline;
        });

        // 컵라면 담는 pq. 작은 수부터 poll
        // pq 크기: 문제 푼 수
        // pq 원소: 문제를 풀고 얻은 컵라면 수
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Problem cur : problems) {
            int size = pq.size();

            if (size < cur.deadline) {
                pq.add(cur.reward);
                continue;
            }

            if (size == cur.deadline) {
                if (pq.peek() < cur.reward) {
                    pq.poll();
                    pq.add(cur.reward);
                }
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}
