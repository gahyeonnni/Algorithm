import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n]; 
        int total = n * (n + 1) / 2;
        int val = 1, x = 0, y = 0, dir = 0;
        int[] dx = {1, 0, -1}; 
        int[] dy = {0, 1, -1};
        
        while (val <= total) {
            map[x][y] = val++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= n || ny < 0 || ny > nx || map[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx; 
            y = ny;
        }
        
        int[] answer = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }
}
