import java.util.*;

class Solution {
    public int solution(int[] pri, int location) {
        int answer = 0;
        Queue <int []> queue = new LinkedList<>();
        for (int i = 0; i < pri.length; i++){
            queue.add(new int [] {pri[i], i});
        }
        Arrays.sort(pri);
        int max = pri.length - 1;
        while (!queue.isEmpty()){
            int [] current = queue.poll();
            if (current[0] == pri[max]){
                answer++;
                max--;
                if (current[1] == location)
                    break;
            }
            else
                queue.add(current);
        }
        return answer;
    }
}