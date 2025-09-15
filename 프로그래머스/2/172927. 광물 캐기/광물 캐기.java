import java.io.*; 
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0; 
        int maxMine = (picks[0] + picks[1] + picks[2]) * 5;
        int n = Math.min(minerals.length, maxMine);

        int[][] cost = {
            {1, 1, 1},    
            {5, 1, 1},    
            {25, 5, 1}   
        };

        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < n; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < n; j++) {
                String m = minerals[j];
                int code = (m.equals("diamond")) ? 0 : (m.equals("iron")) ? 1 : 2;
                dia   += cost[0][code];
                iron  += cost[1][code];
                stone += cost[2][code];
            }
            groups.add(new int[]{dia, iron, stone});
        }

        groups.sort((a, b) -> b[2] - a[2]);

        for (int[] g : groups) {
            if (picks[0] > 0) {        
                answer += g[0];
                picks[0]--;
            } 
            else if (picks[1] > 0) { 
                answer += g[1];
                picks[1]--;
            } 
            else if (picks[2] > 0) { 
                answer += g[2];
                picks[2]--;
            }
        }

        return answer;
    }
}
