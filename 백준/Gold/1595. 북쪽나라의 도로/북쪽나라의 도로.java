import java.io.*;
import java.util.*;

public class Main {

    static int[] dijkstra(int start, List<List<int[]>> graph, int n) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];
            int cost = now[1];

            if (dist[cur] < cost) continue;

            for (int[] next : graph.get(cur)) {
                int v = next[0];
                int w = next[1];
                int newCost = cost + w;

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new int[]{v, newCost});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<int[]> edges = new ArrayList<>();
        int maxNode = 0;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
            maxNode = Math.max(maxNode, Math.max(a, b));
        }

        if (edges.size() == 0) {
            System.out.println(0);
            return;
        }
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= maxNode; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int startNode = edges.get(0)[0];
        int[] dist1 = dijkstra(startNode, graph, maxNode);

        int farNode = startNode;
        for (int i = 1; i <= maxNode; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist1[i] > dist1[farNode]) {
                farNode = i;
            }
        }

        int[] dist2 = dijkstra(farNode, graph, maxNode);

        int answer = 0;
        for (int d : dist2)
            if (d != Integer.MAX_VALUE)
                answer = Math.max(answer, d);

        System.out.println(answer);
    }
}
