import java.io.*; 
import java.util.*; 

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int dir; 
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dir = 0;
                List <Integer> list = new LinkedList<>(); 
                while (dir < 4) {
                    if (dir != j) {
                        list.add(land[i-1][dir]);   
                    }
                    dir++; 
                }
                int max = 0;
                for (int val : list) {
                    max = Math.max(max, val);
                }
                land[i][j] += max; 
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}