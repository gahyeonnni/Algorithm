import java.io.*; 
import java.util.*; 

class Solution {
    static void plustime(Queue<int[]> queue) {
        for (int [] a : queue)
            a[1]++;
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList<>(); 
        int time = 0;
        int index = 0;
        while (true) {
            
            if (index == truck_weights.length && queue.isEmpty()) {
                break;
            }
            
            time++; 
            
            plustime(queue); 
            
            if (queue.size() > bridge_length)
                continue; 
            
             if (!queue.isEmpty() && queue.peek()[1] >= bridge_length) {
                queue.poll();
            }  
            
            int sum = 0;
            for (int [] a : queue)
                sum += a[0];
            
            
            if (index < truck_weights.length) {
                if (sum + truck_weights[index] <= weight) {
                    queue.add(new int[] {truck_weights[index], 0});
                    index++; 
                }
            }
                      
        }
        return time;
    }
}