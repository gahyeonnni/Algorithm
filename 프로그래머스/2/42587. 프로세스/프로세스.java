import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue <int []> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++){
            queue.add(new int [] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        
        int index = priorities.length - 1;
        
        while (!queue.isEmpty()){
            int [] xo = queue.poll();
            if (xo[0] == priorities[index]){
                index--;
                answer++;
                if (xo[1] == location)
                    return answer;
            }
            queue.add(xo);
        }
        return answer;
    }
}