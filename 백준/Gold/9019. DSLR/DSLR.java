import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);
        }
    }
    static void bfs(int a, int b) {
        Queue <Integer> queue = new LinkedList<>();
        String[] answer = new String[10000];
        visited = new boolean [10000];

        queue.add(a);
        answer[a] = "";
        visited[a] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == b) {
                System.out.println(answer[b]);
                return;
            }

            int D = (x * 2) % 10000;
            int S = (x == 0) ? 9999 : x - 1;
            int L = (x % 1000) * 10 + (x / 1000);
            int R = (x % 10) * 1000 + (x / 10);

            if (!visited[D]) {
                visited[D] = true;
                answer[D] = answer[x] + "D";
                queue.add(D);
            }
            if (!visited[S]) {
                visited[S] = true;
                answer[S] = answer[x] + "S";
                queue.add(S);
            }
            if (!visited[L]) {
                visited[L] = true;
                answer[L] = answer[x] + "L";
                queue.add(L);
            }
            if (!visited[R]) {
                visited[R] = true;
                answer[R] = answer[x] + "R";
                queue.add(R);
            }
        }
    }
}
