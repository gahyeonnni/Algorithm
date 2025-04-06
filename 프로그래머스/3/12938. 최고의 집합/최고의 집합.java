import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) 
            return new int[]{-1};

        int[] answer = new int[n];
        int a = s / n;
        int b = s % n;

        Arrays.fill(answer, a);
        
        for (int i = n - 1; b > 0; i--, b--) {
            answer[i]++;
        }

        return answer;
    }
}
