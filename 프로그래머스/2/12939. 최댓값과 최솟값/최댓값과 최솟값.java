import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String [] len = s.split(" ");
        int min = Integer.parseInt(len[0]);
        int max = Integer.parseInt(len[0]);
        for (int i = 1; i < len.length; i++){
            int a =  Integer.parseInt(len[i]);;
            max = Math.max(a,max);
            min = Math.min(a,min);
            
        }
        answer += String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}