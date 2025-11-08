import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static List<List<int[]>> list;
    static List<List<int[]>> reverseList;

    static int[] dijkstra(List<List<int[]>> graph, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now])
                continue;

            for (int[] next : graph.get(now)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, t});
            reverseList.get(b).add(new int[]{a, t});
        }

        int[] go = dijkstra(list, x);
        int[] come = dijkstra(reverseList, x);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (go[i] != Integer.MAX_VALUE && come[i] != Integer.MAX_VALUE) {
                answer = Math.max(answer, go[i] + come[i]);
            }
        }

        System.out.println(answer);
    }
}
