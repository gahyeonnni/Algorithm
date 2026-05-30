import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int [][] dp = new int [money.length][n+1];
        
        for (int i = 0; i < money.length; i++) 
            dp[i][0] = 1;
        
        for (int i = 0; i < money.length; i++) {
            int m = money[i]; 
            
            for (int j = 1; j <= n; j++) {
                int noCoin = 0; 
                if (i >= 1)
                    noCoin = dp[i-1][j]; 
                
                int withCoin = 0; 
                if (j >= m)
                    withCoin = dp[i][j - m]; 
                
                dp[i][j] = (noCoin + withCoin) % 1000000007;
            }
        }
        return dp[money.length - 1][n];
    }
}