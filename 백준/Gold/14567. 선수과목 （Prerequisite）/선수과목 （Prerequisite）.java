import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            lists[i] = new ArrayList<>();

        int [] degree = new int [n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degree[b]++;
            lists[a].add(b);
        }

        Queue <Integer> queue = new LinkedList<>();
        int [] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                ans[i]++;
            }
        }

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int next : lists[cur]) {
                degree[next]--;
                if (degree[next] == 0) {
                    ans[next] = ans[cur] + 1;
                    queue.add(next);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++)
            stringBuilder.append(ans[i]).append(" ");

        System.out.println(stringBuilder.toString());
    }
}