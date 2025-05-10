import java.io.*;
import java.util.*; 

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List <List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) 
            graph.add(new ArrayList<>());
        
        for (int [] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] ans = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        ans[1] = 0;
        
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int x : graph.get(a)) {
                if (!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                    ans[x] = ans[a] + 1;
                }
            }
        }
        int max = 0;
        for (int d : ans) {
            max = Math.max(max, d);
        }

        for (int d : ans) {
            if (d == max)
                answer++;
        }

        return answer;
    }
}