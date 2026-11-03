import java.io.*; 
import java.util.*; 

class Solution {
    static int [] dx = {1, 0}; 
    static int [] dy = {0, 1};
    static final int MOD = 1_000_000_007;          

    public int solution(int m, int n, int[][] puddles) {
        boolean [][] arr = new boolean [m][n];
        int [][] cnt = new int [m][n];               
        boolean [][] visited = new boolean [m][n];   
        
        for (int [] puddle : puddles) {
            int a = puddle[0] - 1; 
            int b = puddle[1] - 1; 
            if (a >= 0 && b >= 0 && a < m && b < n) {
                arr[a][b] = true;
            }
        }
        
        if (arr[0][0])
            return 0; 
        
        Queue <int []> queue = new ArrayDeque<>(); 
        queue.add(new int [] {0, 0});
        cnt[0][0] = 1;                               
        visited[0][0] = true;                        
        m -= 1; 
        n -= 1;
        
        while (!queue.isEmpty()) {
            int [] x = queue.poll();
            int a = x[0]; 
            int b = x[1];
            
            for (int i = 0; i < 2; i++) {
                int newa = a + dx[i]; 
                int newb = b + dy[i];
                if (newa >= 0 && newb >= 0 && newa <= m && newb <= n) {
                    if (!arr[newa][newb]) {
                        cnt[newa][newb] = (cnt[newa][newb] + cnt[a][b]) % MOD;
                        if (!visited[newa][newb]) {  
                            visited[newa][newb] = true;
                            queue.add(new int [] {newa, newb});
                        }
                    }
                }
            }
        }
            
       return cnt[m][n];       
    }
}