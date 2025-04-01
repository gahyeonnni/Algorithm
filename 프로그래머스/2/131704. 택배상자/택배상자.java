import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        int a = order.length;
        for (int i = 1; i <= a; i++) {
            queue.add(i);
        }

        int idx = 0; 

        while (idx < order.length) {
            if (!queue.isEmpty() && queue.peek() == order[idx]) {
                queue.poll();
                answer++;
                idx++;
            } 
            else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
            } 
            else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } 
            else {
                break; 
            }
        }

        return answer;
    }
}
