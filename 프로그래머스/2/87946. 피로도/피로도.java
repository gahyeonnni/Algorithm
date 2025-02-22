import java.util.*;

class Solution {
    private static int answer = 0;
    private static boolean [] visit;
    
    private static void check(int k, int [][] dungeons, boolean [] visit, int people){
        answer = Math.max(answer, people);
        
        for (int i = 0; i < dungeons.length; i++){
            if (!visit[i]){
                int [] x = dungeons[i];
                if (k >= x[0]){
                    visit[i] = true;
                    check(k - x[1], dungeons, visit, people + 1);
                    visit[i] = false;
                }
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        visit = new boolean [dungeons.length];
        int people = 0;
        check(k, dungeons, visit, people);
        return answer;
    }
}