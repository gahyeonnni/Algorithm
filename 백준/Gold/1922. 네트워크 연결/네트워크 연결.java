import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static StringTokenizer st;
    static List<List<int[]>> list;
    static int cost;
    static int ans;
    static boolean [] visited;
    static int allofcomputer(List<List<int[]>> list, int a, int cost, boolean[] visited){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{a, 0});
        int total = 0;

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int node = cur[0];
            int num = cur[1];

            if (visited[node])
                continue;

            visited[node] = true;
            total += num;

            for (int [] next : list.get(node)) {
                if (!visited[next[0]]) {
                    queue.add(new int [] {next[0], next[1]});
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }
        visited = new boolean [n + 1];
        ans = allofcomputer(list,1, 0, visited);
        System.out.println(ans);
    }
}

