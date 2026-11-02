import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] sco, int K) {
        int answer = 0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sco.length; i++)
            pq.add(sco[i]); 
        
        while (pq.peek() < K) {
            if (pq.size() < 2)     
                return -1;
            int a = pq.poll();
            int b = pq.poll(); 
            pq.add(a + b * 2);       
            answer++;  
        }
        return answer;
    }
}