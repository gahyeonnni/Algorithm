import java.util.*;

class Solution {
    private static int [][] ans;
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        int rows = (n % w == 0) ? (n / w) : (n / w) + 1;
        ans = new int[rows][w];

        int a = -1, b = -1;  
        int index = 1;

        for (int i = 0; i < rows; i++) { 
            if (i % 2 == 0) { 
                for (int j = 0; j < w; j++) { 
                    if (index > n) 
                        break;
                    ans[(rows - 1) - i][j] = index;
                    if (index == num) {
                        a = (rows - 1) - i;
                        b = j;
                    }
                    index++;
                }
            } 
            else {  
                for (int j = w - 1; j >= 0; j--) {
                    if (index > n) 
                        break;
                    ans[(rows - 1) - i][j] = index;
                    if (index == num) {
                        a = (rows - 1) - i; 
                        b = j;
                    }
                    index++;
                }
            }
        }

        for (int i = 0; i <= a; i++) {
            if (ans[i][b] != 0)
                answer++;
        }
        
        return answer;
    }
}
