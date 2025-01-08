import java.util.*;

class Solution {
    private Queue<Integer> queue = new LinkedList<>();
    private int answer = 0;

    public void BFS(int[] numbers, int target) {
        queue.add(0);
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int sum = queue.poll(); 
                queue.add(sum + numbers[i]); 
                queue.add(sum - numbers[i]); 
            }
        }

        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                answer++;
            }
        }
    }

    public int solution(int[] numbers, int target) {
        BFS(numbers, target);
        return answer; 
    }
}
