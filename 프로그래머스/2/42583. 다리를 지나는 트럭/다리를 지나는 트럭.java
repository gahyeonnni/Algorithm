import java.util.*;

class Solution {
    public int solution(int bri, int wei, int[] truck) {
        int answer = 0;
        int total = 0;
        Queue <Integer> queue1 = new LinkedList<>(); //트럭 리스트
        Queue <int []> queue2 = new LinkedList<>(); //다리에 있는 트럭 
        
        for (int x : truck){
            queue1.add(x);
        }
        
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            
            answer++;
            
            if (!queue2.isEmpty() && queue2.peek()[1] == bri){
                total -= queue2.poll()[0];
            }
            
            if (!queue1.isEmpty() && total + queue1.peek() <= wei){
                int a = queue1.poll();
                total += a;
                queue2.add(new int [] {a, 0});
            }
            
            for (int [] x : queue2){
                x[1]++;
            }
        }
        
        return answer;
    }
}