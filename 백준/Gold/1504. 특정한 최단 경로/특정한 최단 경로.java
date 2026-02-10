import java.io.*;
import java.util.*;

public class Main {
    static int n, e;
    static int v1, v2;

    static int[] dijkstra( Map <Integer, Map <Integer, Integer>> map, int start) {
        int [] dist = new int [n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int [] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];

            if (b > dist[a])
                continue;

            for (int k : map.get(a).keySet()) {
                int cost = map.get(a).get(k) + b;
                if (cost < dist[k]) {
                    pq.add(new int [] {k, cost});
                    dist[k] = cost;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        Map <Integer, Map <Integer, Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).put(b, c);
            map.get(b).put(a, c);
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] distFromStart = dijkstra(map, 1);
        int[] distFromV1 = dijkstra(map, v1);
        int[] distFromV2 = dijkstra(map, v2);
        

        int result = Integer.MAX_VALUE;
        
        if (distFromStart[v1] != Integer.MAX_VALUE && distFromV1[v2] != Integer.MAX_VALUE && distFromV2[n] != Integer.MAX_VALUE) {
            int path1 = distFromStart[v1] + distFromV1[v2] + distFromV2[n];
            result = Math.min(result, path1);
        }
        if (distFromStart[v2] != Integer.MAX_VALUE && distFromV2[v1] != Integer.MAX_VALUE && distFromV1[n] != Integer.MAX_VALUE) {
            int path2 = distFromStart[v2] + distFromV2[v1] + distFromV1[n];
            result = Math.min(result, path2);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}