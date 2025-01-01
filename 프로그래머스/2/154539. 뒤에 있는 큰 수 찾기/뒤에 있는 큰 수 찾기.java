import java.io.*;   
import java.util.*; 

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = numbers.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()) {
                if(stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } 
                else {
                    stack.pop();
                }
            }
            stack.push(numbers[i]);
            if(answer[i] == 0) 
                 answer[i] = -1;
        }

        return answer;
    }
}
