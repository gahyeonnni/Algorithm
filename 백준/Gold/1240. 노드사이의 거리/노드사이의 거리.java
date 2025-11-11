import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List <List <int []>> list;
    static boolean [] check;
    static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        check[start] = true;

        while (!queue.isEmpty()) {
            int  [] x = queue.poll();
            int now = x[0];
            int nowdist = x[1];

            if (now == end) {
                return nowdist;
            }
            for (int [] a : list.get(now)) {
                int node = a[0];
                int dist = a[1];
                if (!check[node]) {
                    check[node] = true;
                    queue.add(new int [] {node, nowdist + dist});
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean [n+1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < (n - 1); i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.get(x).add(new int [] {y, z});
            list.get(y).add(new int [] {x, z});
        }
        for (int i = 0; i < m; i++) {
            Arrays.fill(check, false);
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = bfs(x, y);
            System.out.println(sum);
        }
    }
}
