import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int rSize, cSize;
    static Queue<Point> fQ = new ArrayDeque<>();
    static Queue<Point> jQ = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][] fireMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rSize = Integer.parseInt(st.nextToken());
        cSize = Integer.parseInt(st.nextToken());
        fireMap = new int[rSize][cSize];    // 불 확산 시간 (시작 시간: 1초)
        visited = new boolean[rSize][cSize];

        for (int i = 0; i < rSize; i++) {
            String s = br.readLine();
            for (int j = 0; j < cSize; j++) {
                char c = s.charAt(j);

                if (c == '#') {
                    fireMap[i][j] = -1;
                } else if (c == 'F') {
                    fQ.add(new Point(i, j, 1));
                    fireMap[i][j] = 1;
                } else if (c == 'J') {
                    jQ.add(new Point(i, j, 1));
                    visited[i][j] = true;
                }
            }
        }   // 입력 끝

        fMove();

        int ans = jMove();
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    static void fMove() {
        while (!fQ.isEmpty()) {
            Point cur = fQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= rSize || nc >= cSize || fireMap[nr][nc] != 0)
                    continue;

                fireMap[nr][nc] = cur.time;
                fQ.add(new Point(nr, nc, cur.time + 1));
            }
        }
    }

    static int jMove() {
        while (!jQ.isEmpty()) {
            Point cur = jQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= rSize || nc >= cSize)
                    return cur.time;

                if (visited[nr][nc] || fireMap[nr][nc] == -1
                        || (fireMap[nr][nc] != 0 && fireMap[nr][nc] <= cur.time))    // 불 확산 <= 현재 시간
                    continue;

                jQ.add(new Point(nr, nc, cur.time + 1));
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}
