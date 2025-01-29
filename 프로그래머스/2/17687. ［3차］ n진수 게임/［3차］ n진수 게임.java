import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String num = "";
        int totalnum = t * m;
        for (int i = 0; i < totalnum; i++){
            String x = Integer.toString(i,n);
            num += x;
        }
        for (int i = (p - 1); i < t * m; i += m){
            char c = num.charAt(i);
            if (c >= '0' && c <= '9')
                answer += c;
            else
                answer +=  Character.toUpperCase(c);
        } 
        return answer;
    }
}