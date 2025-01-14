import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++){
            int x = people[i];
            stack.push(x);
            queue.add(x);
        }
        int a = 0;
        int b = people.length;
        while (b > a && !stack.isEmpty()&& !queue.isEmpty()) {
            if (stack.peek() + queue.peek() > limit){
                stack.pop();
                a++;
                answer++;
            }
            else {
                stack.pop();
                queue.remove();
                a++;
                b--;
                answer++;
            }
        }
        return answer;
    }
}