import java.io.*;
import java.util.*;

class Solution {
    private int [] dx = {-1,1,0,0};
    private int [] dy = {0,0,-1,1};
    private Queue<int[]> queue = new LinkedList<>(); 
    private int [][] visited;
    private int answer = 0;
    
    public void BFS(int [][] maps, int x, int y) {
        
        visited = new int [maps.length][maps[0].length];
        
        queue.add(new int [] {x,y});
        visited[x][y] = 1; 
        
        while (!queue.isEmpty()){
            int [] current = queue.poll();
            int a = current[0];
            int b = current[1];
            for (int i = 0; i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1){
                    queue.add(new int [] {nx,ny});
                    visited[nx][ny] = visited[a][b] + 1;
                }
                 if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                    return; 
                }
            }    
        }
    }
    
    public int solution(int[][] maps) {
        BFS(maps, 0, 0);
        int x = visited[maps.length - 1][maps[0].length - 1];
        if (x == 0)
            answer = -1;
        else
            answer = x;
        return answer;
    }
}