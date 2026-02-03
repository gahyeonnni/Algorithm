import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> map;

    static int[] bfs(int n, int dest) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(dest);
        dist[dest] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : map.get(node)) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    q.add(next);
                }
            }
        }
        
        return dist;
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        map = new HashMap<>();

        for (int i = 1; i <= n; i++) 
            map.put(i, new ArrayList<>());

        for (int[] road : roads) {
            int a = road[0], b = road[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int[] dist = bfs(n, destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]]; 
        }

        return answer;
    }
}
