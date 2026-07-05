import java.io.*; 
import java.util.*; 

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        for (int i =0; i < prices.length; i++) {
            int count = -1;
            for (int j = i; j < prices.length; j++) {
                count++;
                if (prices[j] < prices[i])
                    break;
            }
            answer[i] = count;
        }
        return answer;
    }
}