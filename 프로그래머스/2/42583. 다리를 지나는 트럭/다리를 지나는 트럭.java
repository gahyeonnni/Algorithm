import java.util.*;

class Solution {
    public int solution(int bri, int weight, int[] truck) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();  
        Queue<int[]> queue2 = new LinkedList<>();   
        int total = 0;  

        for (int t : truck){
            queue.add(t);
        }
        
        while (!queue.isEmpty() || !queue2.isEmpty()){
            answer++;
            
            if (!queue2.isEmpty() && queue2.peek()[1] == bri){
                total -= queue2.poll()[0];
            }
                
             if (!queue.isEmpty() && total + queue.peek() <= weight) {
                int x = queue.poll();
                queue2.add(new int[]{x, 0});  
                total += x;
            }
            
            for (int [] t : queue2)
                t[1]++;
        }
        
        return answer;
    }
}
