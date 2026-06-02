import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[][] targets) {
        int answer = 0; 
        
        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });
        
        int last = Integer.MIN_VALUE; 
        
        for (int [] target : targets) {
            if (target[0] >= last) {
                answer++; 
                last = target[1];
            }
        }
        
        return answer;
    }
} 