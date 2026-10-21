import java.io.*; 
import java.util.*;

class Solution {
    public int solution(int[] cit) {
        int answer = 0;
        int len = cit.length; 
        
        for (int h = 0; h <= len; h++) {
            int plus = 0; 
            for (int i = 0; i < len; i++) {
                if (cit[i] >= h)
                    plus++;
            }
            if (plus >= h)
                answer = h;
            
        }
        return answer;
    }
}