import java.util.*;

class Solution {
    private static ArrayList<Integer>[] list;
    private static boolean [] visit;
    
    public static int CHECK(int a, boolean [] visited){
        visited[a] = true;
        int count = 1;
        
        for (int i : list[a]){
            if (!visited[i]){
                count += CHECK(i, visited);
            }
        }
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList [n + 1];
        for (int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++){
            int [] x = wires[i];
            int a = x[0];
            int b = x[1];
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 0; i < wires.length; i++){
            int [] x = wires[i];
            int a = x[0];
            int b = x[1];
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            boolean [] visit = new boolean [n + 1];
            int count = CHECK(1, visit);
            
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            list[a].add(b);
            list[b].add(a);
        }
        return answer;
    }
}