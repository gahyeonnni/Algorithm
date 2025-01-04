import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char input = s.charAt(i);
            if (!stack.isEmpty()){
                if (stack.peek() == input){
                    stack.pop();
                }
                else
                    stack.push(input);
            }
            else
                stack.push(input);
        }
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }
}