import java.io.*;
import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static int m, n;
    
    public int solution(int mInput, int nInput, int[][] puddles) {
        m = mInput;
        n = nInput;
        visited = new boolean [m][n];
        int[][] route = new int[m][n];
        
        for (int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            if (x >= 0 && y >= 0 && x < m && y < n) {
                visited[x][y] = true;
            }
        }

        if (visited[0][0]) 
            return 0;
        
        route[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) 
                    continue; 
                if (i > 0) 
                    route[i][j] = (route[i][j] + route[i - 1][j]) % 1000000007;
                if (j > 0) 
                    route[i][j] = (route[i][j] + route[i][j - 1]) % 1000000007;
            }
        }

        return route[m - 1][n - 1];
    }
}