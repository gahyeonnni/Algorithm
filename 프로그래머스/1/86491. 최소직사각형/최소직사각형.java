import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int galo = 0;
        int selo = 0;
        //회전 시킨 후 
        for (int i = 0; i < sizes.length; i++){
            galo = Math.max(sizes[i][0], galo);
            selo = Math.max(sizes[i][1], selo);
        }
        if (galo > selo){
            for (int i = 0; i < sizes.length; i++){
                if (sizes[i][0] > sizes[i][1])
                    answer = Math.max(sizes[i][1] * galo, answer);
                else
                    answer = Math.max(sizes[i][0] * galo, answer);
            }
        }
        else {
            for (int i = 0; i < sizes.length; i++){
                if (sizes[i][0] > sizes[i][1])
                    answer = Math.max(sizes[i][1] * selo, answer);
                else
                    answer = Math.max(sizes[i][0] * selo, answer);
            }
        }
        return answer;
    }
}