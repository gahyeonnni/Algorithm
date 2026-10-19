import java.io.*; 
import java.util.*; 

class Solution {
    static char left = '(';
    boolean solution(String s) {
        boolean answer = true;
        if (s.length() % 2 != 0)
            return false;
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == left) {
                stack.push(str);
            }
            else {
                if (!stack.isEmpty() && stack.peek() == left) {
                    stack.pop();
                    continue;
                }
            }
        }
        if (stack.size() != 0)
            answer = false;
        return answer;
    }
}