import java.io.*;
import java.util.*;

class Solution {
    private List <Integer> [] arr;
    private boolean [] visited;
    private int answer = 0;
    
    public void BFS(int [][] com, boolean [] visited, int a){
        Queue <Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        
        while (!queue.isEmpty()){
            int x = queue.poll();
            
            for (int va : arr[x]){
                if (!visited[va]){
                    queue.add(va);
                    visited[va] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] com) {
        arr = new LinkedList[n+1];
        visited = new boolean [n];
        
        for (int i = 0; i <= n; i++){
            arr[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < com.length; i++){
            for (int j = 0; j < com[0].length; j++){
                if (com[i][j] == 1 && i != j){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                BFS(com, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
}