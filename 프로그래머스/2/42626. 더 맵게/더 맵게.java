import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        
        boolean xo = true;
        
        for (int a : scoville)
            pq.add(a);
        
        while (pq.size() != 1){
            boolean check = true;
            
            for (int ax : pq){
                if (ax < k){
                    check = !check;
                    break;
                }
            }
            
            if (check)
                break;
            
            if (!check){
                int a = pq.poll();
                int sum = pq.poll() * 2 + a;
                pq.add(sum);
            }
            answer++;
        }
        
        if (pq.size() == 1){
            int a = pq.poll();
            if (a < k)
                answer = -1;
            else
                return answer;
        }
        
        return answer;
    }
}