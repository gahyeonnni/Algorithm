import java.io.*; 
import java.util.*; 

class Solution {
    static int bfs(Map <Integer, List<Integer []>> map, int start, int n) {
        boolean [] visited = new boolean [n]; 
        PriorityQueue <int []> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );
        pq.add(new int[]{start, 0});
        int totalCost = 0;
        int count = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (visited[node])
                continue; 
            
            visited[node] = true; 
            totalCost += cost; 
            count++; 
            
            if (count == n) 
                break; 
            
            for (Integer[] next : map.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (!visited[nextNode]) {
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return totalCost; 
    }
    public int solution(int n, int[][] costs) {
        Map <Integer, List<Integer []>> map = new HashMap<>();
        for (int i = 0; i <= n; i++)
            map.put(i, new ArrayList<>());
        for (int[] a : costs) {
            int x = a[0];
            int y = a[1];
            int z = a[2];

            map.get(x).add(new Integer[]{y, z});
            map.get(y).add(new Integer[]{x, z});
        }
        return bfs(map, 0, n);
    }
}