import java.io.*; 
import java.util.*; 

class Solution {
    public long solution(int[] seq) {
        long answer = 0;
        
        long sum1 = 0; 
        long sum2 = 0; 
        
        for (int i = 0; i < seq.length; i++) {
            long pulse1 = (long) seq[i] * (i % 2 == 0 ? 1 : -1);
            long pulse2 = (long) seq[i] * (i % 2 == 0 ? -1 : 1);
            
            sum1 = Math.max(pulse1, sum1 + pulse1); 
            sum2 = Math.max(pulse2, sum2 + pulse2);
            answer = Math.max(answer, Math.max(sum1, sum2));
        }
        return answer;
    }
}