import java.io.*;
import java.util.*;

class Solution { 
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int INF = Integer.MAX_VALUE; 
        
        int[][] dp = new int[len + 1][m]; 
        for (int[] row : dp) 
            Arrays.fill(row, INF);
        dp[0][0] = 0; 
        
        for (int i = 0; i < len; i++) {
            int a = info[i][0]; 
            int b = info[i][1]; 
            
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == INF) 
                    continue; 
                
                if (dp[i][j] + a < n) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + a); 
                }
                
                if (j + b < m) {
                    dp[i+1][j + b] = Math.min(dp[i+1][j + b], dp[i][j]);
                }
            }
        } 
        
        int answer = INF;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[len][j]);
        }
        
        return (answer == INF) ? -1 : answer;
    }
}
