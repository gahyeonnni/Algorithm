import java.io.*; 
import java.util.*; 

class Solution {
    static int bfs(int k, int [][] dungeons, boolean [] check, int start, int count) {
        Queue <int []> queue = new LinkedList<>(); 
        queue.add(dungeons[start]);
        check[start] = true;
        
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            if (cur[0] > k)
                return count; 
                        
            k -= cur[1]; 
            count++;
            
            int maxCount = count;
            for (int i = 0; i < dungeons.length; i++) {
                if (!check[i]) {
                    check[i] = true; 
                    maxCount = Math.max(maxCount, bfs(k, dungeons, check, i, count));
                    check[i] = false;
                }
            }
            return maxCount;
        }
        
        return count; 
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int n = dungeons.length;
        for (int i = 0; i < n; i++) {
            boolean [] check = new boolean [n];
            answer = Math.max(answer, bfs(k, dungeons, check, i, 0));
        }
        return answer;
    }
}