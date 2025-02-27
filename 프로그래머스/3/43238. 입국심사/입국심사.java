import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long min = 1;
        long a = times[0];
        for (int i : times)
            if (i > a)
                a = i;
        long max = a * n;
        long answer = max;
        while (min <= max)
        {
            long mid = (min + max) / 2;
            long people = 0;
            for (int time : times) {
                people += mid / time;
                if (people >= n) 
                    break;
            }
            if (people >= n){
                max = mid -1;
                answer = mid;
            }
            else
                min = mid+1;
        }
        return answer;
    }
}