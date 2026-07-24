import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int n, int w, int number) {
        int answer = 0;
        int [][] array = new int [n / w + 1][w];
        int cur = 0;
        int num = 1;
        int currow = Integer.MAX_VALUE;
        for (int i = n / w; i >= 0; i--) {
            if (cur == 0) {
                for (int j = 0; j < w; j++) {
                    if (currow != Integer.MAX_VALUE && num <= n && currow == j)
                        answer++;
                    array[i][j] = num;
                    if (num == number) {
                        answer++;
                        currow = j;
                    }
                    num++;
                    if (num > n)
                        return answer;
                }
                cur = 1;
            }
            else if (cur == 1){
                for (int j = w - 1; j >= 0; j--) {
                    if (currow != Integer.MAX_VALUE && num <= n && currow == j)
                        answer++;
                    array[i][j] = num;
                    if (num == number) {
                        answer++;
                        currow = j;
                    }
                    num++;
                    if (num > n)
                        return answer;
                }
                cur = 0;
            }
        }
        
        return answer;
    }
}