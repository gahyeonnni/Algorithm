import java.util.*;

class Solution {
    private static int answer = 0;
    private static boolean [] visit;
    
    private static void CHECK(int [] num, boolean [] visit, int a){
        Queue <Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < num.length; i++){
            if (queue.isEmpty()){
                queue.add(num[i]);
                queue.add(-num[i]);
            }
            else {
                int size = queue.size();
                for (int j = 0; j < size; j++){
                    int n = queue.poll();
                    queue.add(n + num[i]);
                    queue.add(n - num[i]);
                }
            }
        }
        
        for (int x : queue){
            if (x == a)
                answer++;
        }
    }
    
    public int solution(int[] numbers, int target) {
        visit = new boolean [numbers.length];
        CHECK(numbers, visit, target);
        return answer;
    }
}