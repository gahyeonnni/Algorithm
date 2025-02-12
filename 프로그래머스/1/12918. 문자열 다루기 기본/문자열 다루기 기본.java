import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() < 4 || s.length() > 6 || s.length() == 5)
            answer = false;

        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i)) == false){
                answer = false;
                break;
            }
        }
        return answer;
    }
}