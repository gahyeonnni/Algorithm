import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue <Integer> queue = new PriorityQueue<>(); 
        for (int a : scoville)
            queue.add(a); 
        while (!queue.isEmpty() && queue.peek() < k) {
            if (queue.size() < 2)
                return -1;
            int a = queue.poll(); 
            int b = queue.poll(); 
            int x = a + 2 * b; 
            queue.add(x); 
            answer++;
        }
        return answer;
    }
}