import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 1)
            return false;
        Stack <String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
          String x = String.valueOf(s.charAt(i));
            if(x.equals("("))
                stack.push(x);
            else {
                if (!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else if (!stack.isEmpty() && stack.peek().equals(")"))
                    return false;
                else if (stack.isEmpty())
                    return false;
            }
        }
        if (!stack.isEmpty())
            answer = !answer;
        return answer;
    }
}