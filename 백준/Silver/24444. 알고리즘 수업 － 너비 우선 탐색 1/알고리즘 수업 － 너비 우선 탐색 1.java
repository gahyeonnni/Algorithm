import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int [] answer;
    static boolean [] check;

    static void bfs(List<List<Integer>> list, int start, int num) {
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        answer[start] = num++;
        queue.add(start);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int a : list.get(x)) {
                if (!check[a]) {
                    check[a] = true;
                    answer[a] = num++;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        check = new boolean[n + 1];
        answer = new int[n + 1];
        bfs(list, r, 1);

        for (int i = 1; i <= n; i++)
            System.out.println(answer[i]);
    }
}
