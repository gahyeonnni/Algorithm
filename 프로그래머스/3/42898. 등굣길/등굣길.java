import java.io.*; 
import java.util.*; 

class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0; 
        int [][] dp = new int [n+1][m+1]; 
 
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1; 
        }

        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) { 
                if (i == 1 && j == 1) 
                        continue;  
               
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; 
                    continue;
                } 
                
                int a = 0; 
                int b = 0;
                if (dp[i-1][j] == -1)
                    a = 0; 
                else 
                    a = dp[i-1][j];
                
                if (dp[i][j-1] == -1)
                    b = 0; 
                else 
                    b = dp[i][j-1]; 
                
                dp[i][j]  = (a + b) % MOD;
            }
        }
        answer = dp[n][m];
        return answer;
    }
}