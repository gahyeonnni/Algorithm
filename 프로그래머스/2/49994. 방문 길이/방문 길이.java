import java.util.*;

class Solution {
    private boolean [][][] visited;
    private int answer = 0;  
    
    public int solution(String dirs) {
        visited = new boolean [11][11][4];
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++){
            char dx = dirs.charAt(i);
            int dir = -1;
            if (dx == 'U' && (y + 1) < visited.length){
                visited[y][x][1] = true;
                y += 1;
                dir = 0;
            }
            else if (dx == 'D' && (y - 1) >= 0){
                visited[y][x][0] = true;
                y -= 1;
                dir = 1;
            }  
            else if (dx == 'R' && (x + 1) < visited[0].length){
                visited[y][x][3] = true;
                dir = 2;
                x += 1;
            }  
            else if (dx == 'L' && (x - 1) >= 0) {
                visited[y][x][2] = true;
                x -= 1;
                dir = 3;
            }
            if (dir == -1)
                continue;
            if (!visited[y][x][dir]){
                answer++;
                visited[y][x][dir] = true;
            }
        }
        return answer;
    }
}