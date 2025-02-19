import java.util.*;

class Solution {
    private static int answer = 0;
    
    private static void CHECK(int k, int people, int [][] num, boolean [] visit){
        
        answer = Math.max(people, answer);
        
        for (int i = 0; i < num.length; i++){
            if (!visit[i] && k >= num[i][0]){
                visit[i] = true;
                CHECK(k - num[i][1], people + 1, num, visit);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dun) {
        boolean [] visit = new boolean [dun.length];
        CHECK(k, 0, dun, visit);
        return answer;
    }
}