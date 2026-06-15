import java.io.*; 
import java.util.*; 

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum1 = 0; 
        long sum2 = 0; 
        
        for (int i = 0; i < sequence.length;  i++) {
            long value1 = (i % 2 == 0) ? sequence[i] : sequence[i] * -1; 
            long value2 = (i % 2 == 0) ? sequence[i] * -1: sequence[i];
            
            sum1 = Math.max(sum1 + value1, value1); 
            sum2 = Math.max(sum2 + value2, value2);
            
            answer = Math.max(answer, Math.max(sum1, sum2));
        }
        return answer;
    }
}