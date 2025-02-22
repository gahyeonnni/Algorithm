import java.util.*;

class Solution {
    private static ArrayList <Integer> [] list;
    private static int answer = Integer.MAX_VALUE;
    
    private static int BFS(int a, boolean [] visited){
        Queue <Integer> queue = new LinkedList<>();
        visited[a] = true;
        queue.add(a);
        
        int count = 0;
        
        while (!queue.isEmpty()){
            int x = queue.poll();
            count++;
            
            for (int next : list[x]){
                if (!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        
        for (int i = 0; i < wires.length; i++){
            int [] x = wires[i];
            list[x[0]].add(x[1]);
            list[x[1]].add(x[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int [] x = wires[i];
            
            list[x[0]].remove(Integer.valueOf(x[1]));
            list[x[1]].remove(Integer.valueOf(x[0]));
            
            boolean [] visited = new boolean [n+1];
            int count = BFS(1, visited);
            
            int diff = Math.abs(count - (n - count));
            answer = Math.min(diff, answer);
            
            list[x[0]].add(x[1]);
            list[x[1]].add(x[0]);
        }
        
        return answer;
    }
}