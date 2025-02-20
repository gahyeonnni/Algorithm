import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if (a == '(')
                stack.push(a);
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() == a)
                    return false;
                if (stack.peek() == '(')
                    stack.pop();
            }
        }
        if (!stack.isEmpty())
            answer = false;
        return answer;
    }
}