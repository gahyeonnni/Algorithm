import java.io.*; 
import java.util.*; 

class Solution {
    static int n; 
    static int [] dx = {-1, 1, 0, 0}; 
    static int [] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        n = board.length;
        
        Queue <int []> queue = new LinkedList<>(); 
        queue.add(new int [] {0, 0, -1}); 
        
        int [][][] cost = new int [n][n][4]; 
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < 4; i++)
            cost[0][0][i] = 0;  
        
        while (!queue.isEmpty()) {
            int [] cur = queue.poll(); 
            int a = cur[0]; 
            int b = cur[1]; 
            int dir = cur[2]; 
            
            for (int i = 0; i < 4; i++) {
                int tx = a + dx[i]; 
                int ty = b + dy[i]; 
                if (tx < 0 || ty < 0 || tx >= n || ty >= n) 
                    continue;
                if (board[tx][ty] == 1)
                    continue; 
                
                int curCost; 
                if (dir == -1)
                    curCost = 0; 
                else 
                    curCost = cost[a][b][dir]; 
                
                int next = curCost + 100; 
                if (dir != -1 && dir != i)
                    next += 500; 
                
                if (cost[tx][ty][i] > next) {
                    cost[tx][ty][i] = next;
                    queue.add(new int[]{tx, ty, i});
                }
            }
        } 
        
        int ans = Integer.MAX_VALUE; 
        for (int i = 0; i < 4; i++)
            ans = Math.min(ans, cost[n-1][n-1][i]);
        return ans;
    }
}