import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            if (stack.isEmpty())
                stack.add(arr[i]);
            else {
                if (stack.peek() == arr[i])
                    continue;
                else
                    stack.add(arr[i]);
            }
        }
        Queue <Integer> queue = new LinkedList<>();
        for (int i : stack)
            queue.add(i);
        int[] answer = new int [queue.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = queue.poll();
        return answer;
    }
}
