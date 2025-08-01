import java.util.*;
import java.io.*;

class Pair {
    int age;
    String name;

    public Pair(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Pair(age, name));
        }

        // 연산
        list.sort(Comparator.comparingInt(p -> p.age));

        // 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).age).append(" ").append(list.get(i).name).append('\n');
        }
        
        System.out.println(sb);
    }
}
