import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String [] len = s.split(" ", -1);
        for (int j = 0; j < len.length; j++){
            StringBuilder sb = new StringBuilder(len[j]);
            boolean dec = true;
            for (int i = 0; i < sb.length(); i++){
                if (dec == true){
                    if (sb.charAt(i) >= 97 && sb.charAt(i) <= 122)
                        sb.setCharAt(i, (char) (sb.charAt(i) - 32));
                    dec = false;
                }
                else {
                    if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90)
                        sb.setCharAt(i, (char) (sb.charAt(i) + 32));
                    dec = true;
                }
            }
            len[j] = sb.toString();
        }
        for (int i = 0; i < len.length - 1; i++){
            answer += len[i] + " ";
        }
        answer += len[len.length - 1];
        return answer;
    }
}