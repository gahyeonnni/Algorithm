import java.io.*; 
import java.util.*; 

class Solution {
    private List<Integer>[] arr; 
    private int answer = 0; 
    private boolean [] check; 
    
    private void BFS(int [][] computers, boolean [] check, int start) {
        Queue <Integer> queue = new LinkedList<>(); 
        queue.add(start); 
        check[start] = true; 
        
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int va : arr[a]) {
                if (!check[va]) {
                    queue.add(va); 
                    check[va] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        check = new boolean [n + 1]; 
        arr = new LinkedList[n + 1]; 
        
        for (int i = 0; i <= n; i++)
            arr[i] = new LinkedList<>(); 
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    arr[i].add(j); 
                    arr[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                BFS(computers, check, i); 
                answer++;
            }
        }
        
        return answer;
    }
}