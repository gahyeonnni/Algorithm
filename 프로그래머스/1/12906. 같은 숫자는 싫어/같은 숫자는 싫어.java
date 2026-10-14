import java.util.*;
import java.io.*; 


public class Solution {
    public int[] solution(int []arr) {
        Stack <Integer> stack = new Stack<>();
        for (int a : arr) {
            if (stack.isEmpty())
                stack.push(a);
            else {
                if (stack.peek() != a)
                    stack.push(a);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int s : stack)
            list.add(s); 
        
        int[] answer = new int [list.size()];

        
        for (int i = 0; i < answer.length; i++) 
            answer[i] = list.get(i);

        return answer;
    }
}