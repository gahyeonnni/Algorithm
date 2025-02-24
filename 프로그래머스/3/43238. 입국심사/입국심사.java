import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int maxTime = times[0];
        
        for (int t : times) {
            if (t > maxTime) {
                maxTime = t;
            }
        }
        
        long low = 1;
        long high = (long) maxTime * n;
        long answer = high;
        
        while (low <= high) {
            long mid = (low + high) / 2;  
            long count = 0;
            
            for (int time : times) {
                count += mid / time;
                if (count >= n) 
                    break;
            }
            
            if (count >= n) {
                answer = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
}
