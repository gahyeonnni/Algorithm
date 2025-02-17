import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int [] solu = new int [players.length];
        for (int i = 0; i < players.length; i++){
            int s = 0;
            if (players[i] > solu[i] * m){
                s = players[i] / m;
                s -= solu[i];
            }
            
            for (int j= 0; j < k; j++){
                if (i + j < solu.length){
                     solu[i+j] += s;
                }
            }
            answer += s;
        }
        return answer;
    }
}