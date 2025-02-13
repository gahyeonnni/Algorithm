import java.util.*;

class Solution {
    public int[] solution(int[] progress, int[] speeds) {
        Queue <Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progress.length; i++){
            int mont = 0;
            while (progress[i] < 100){
                progress[i] += speeds[i];
                mont++;
            }
            queue.add(mont);
        }
        
        List<Integer> list = new LinkedList<>();
        
        while (!queue.isEmpty()){
            int x = queue.poll();
            int check = 1;
            
            while (!queue.isEmpty() && queue.peek() <= x){
                check++;
                queue.poll();
            }
            
            list.add(check);
        }
        
        int [] answer = new int [list.size()];
        int index = 0;
        for (int x : list){
            answer[index++] = x;
        }
        
        return answer;
    }
}