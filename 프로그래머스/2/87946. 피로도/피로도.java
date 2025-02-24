import java.util.*;

class Solution {
    private static int answer = 0;
    
    private static void CHECK(int k, boolean [] visit, int [][] dungeons, int a){
        
        answer = Math.max(a, answer);
        
        for (int i = 0; i < dungeons.length; i++){
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                CHECK(k - dungeons[i][1], visit, dungeons, a + 1);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean [] visit = new boolean [dungeons.length];
        CHECK(k, visit, dungeons, 0);
        return answer;
    }
}