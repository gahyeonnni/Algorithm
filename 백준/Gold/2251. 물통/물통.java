import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int [] array = new int [3];
    static boolean [][][] visited;
    static boolean [] result;
    static void bfs(int a, int b, int c) {
        Queue <int[]> queue = new LinkedList<>();
        queue.add(new int [] {a, b, c});
        visited[a][b][c] = true;
        result[c] = true;

        while (!queue.isEmpty()) {
            int [] now = queue.poll();
            a = now[0];
            b = now[1];
            c = now[2];

            if (a == 0)
                result[c] = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;

                    int[] next = {a, b, c};
                    int move = Math.min(next[i], array[j] - next[j]);
                    next[i] -= move;
                    next[j] += move;

                    if (!visited[next[0]][next[1]][next[2]]) {
                        visited[next[0]][next[1]][next[2]] = true;
                        queue.offer(next);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        array[0] = Integer.parseInt(st.nextToken());
        array[1] = Integer.parseInt(st.nextToken());
        array[2] = Integer.parseInt(st.nextToken());
        visited = new boolean [201][201][201];
        result = new boolean [201];

        bfs(0, 0, array[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 200; i++) {
            if (result[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
