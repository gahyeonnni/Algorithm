import java.util.*;

class Solution {
    private static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];

            graph[x].remove(Integer.valueOf(y));
            graph[y].remove(Integer.valueOf(x));

            boolean[] visited = new boolean[n + 1];
            int networkSize = dfs(1, visited); 
            
            int diff = Math.abs(networkSize - (n - networkSize));
            answer = Math.min(answer, diff);

            graph[x].add(y);
            graph[y].add(x);
        }

        return answer;
    }

    private int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
    }
}
