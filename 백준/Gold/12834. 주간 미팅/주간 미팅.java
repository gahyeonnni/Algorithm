import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int a, b;
    static StringTokenizer st;
    static int [] dijkstra(List<List<int[]>> graph, int start, int m) {
        int [] dist = new int [m + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int [] {start, 0});

        while (!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1]; 
            
            if (cost > dist[now])
                continue; 
            
            for (int [] a : graph.get(now)) {
                int x = a[0]; 
                int y = a[1] + cost;  
                if (y < dist[x]) {
                    dist[x] = y; 
                    pq.offer(new int [] {x, y});
                }
            }

        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int [] array = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= m; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.get(x).add(new int [] {y, z});
            list.get(y).add(new int [] {x, z});
        }

        int[] distA = dijkstra(list, a, m);
        int[] distB = dijkstra(list, b, m);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int c = array[i];
            if (distA[c] == Integer.MAX_VALUE || distB[c] == Integer.MAX_VALUE)
                sum += -1;
            else
                sum += distA[c] + distB[c];
        }
        System.out.println(sum);
    }
}