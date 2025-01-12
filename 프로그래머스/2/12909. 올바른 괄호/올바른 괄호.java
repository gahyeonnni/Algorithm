import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character a = s.charAt(i);
            if (a.equals('('))
                stack.push(a);
            else {
                if (stack.isEmpty()){
                    answer = !answer;
                    break;
                }
                if (!stack.isEmpty()){
                    if (stack.peek().equals(')'))
                        answer = !answer;
                    else
                        stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            answer = !answer;
        return answer;
    }
}