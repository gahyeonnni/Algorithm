import java.io.*;
import java.util.*; 

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1; 
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2; 
            int a = 0; //그 전 바위
            int b = 0; //제거한 바위
            
            for (int rock : rocks) {
                if (rock - a < mid)
                    b++;
                else 
                    a = rock;
            }
            
            if (distance - a < mid)
                b++;
            
            if (b > n)
                right = mid - 1; 
            else {
                answer = mid; 
                left = mid + 1;
            }
        }
        
        return answer;
    }
}