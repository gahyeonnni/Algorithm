import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String[] alpha = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        }; //26개 
        for (int i = 0; i < s.length(); i++){
            String x = String.valueOf(s.charAt(i));
            System.out.println(x);
            int num = 0;
            for (int j = 0; j < alpha.length; j++){
                if (x.equals(alpha[j])){
                     num = j;
                     break;
                }
                else
                    continue;
            }
            System.out.println(num);
            int in = index;
            System.out.println(in);
            while (in-- > 0){
                num++;
                if (num == 26)
                    num = 0;
                while (skip.contains(alpha[num])){
                    num++;
                    if (num == 26)
                        num = 0;
                }
            }
            answer += alpha[num];System.out.println(answer); 
        }
        return answer;
    }
}