import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int x : lost) {
            answer[x - 1]--;
        }

        for (int x : reserve) {
            answer[x - 1]++;
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) { 
                if (i > 0 && answer[i - 1] == 2) { 
                    answer[i]++;
                    answer[i - 1]--;
                } 
                else if (i < answer.length - 1 && answer[i + 1] == 2) { 
                    answer[i]++;
                    answer[i + 1]--;
                }
            }
        }
        int ans = 0;
        for (int x : answer) {
            if (x > 0) {
                ans++;
            }
        }
        return ans;
    }
}
