import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] pri, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < pri.length; i++) {
            queue.offer(new int[]{pri[i], i});
        }

        int answer = 0;

        Arrays.sort(pri);
        int max = pri.length - 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[0] == pri[max]) {
                answer++; 
                max--; 
                
                if (current[1] == location) {
                    return answer;
                }
            } 
            
            else {
                queue.offer(current);
            }
        }

        return answer;
    }
}
