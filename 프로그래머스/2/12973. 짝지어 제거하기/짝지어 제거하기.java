import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 연속된 같은 문자 제거
            } 
            else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
