import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue <Integer> queue = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++){
            if (queue.isEmpty()){
                queue.add(numbers[i]);
                queue.add(-numbers[i]);
            }
            else {
                int a = queue.size();
                for (int j = 0; j < a; j++){
                    int x = queue.poll();
                    queue.add(x + numbers[i]);
                    queue.add(x - numbers[i]);
                }
            }
        }
        for (int i : queue)
            if (i == target)
                answer++;
        return answer;
    }
}