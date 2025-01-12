import java.io.*;
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        double pvalue = Double.parseDouble(p);
        for (int i = 0; i <= t.length() - len; i++){
            String subString = t.substring(i, i + len); 
            double currentValue = Double.parseDouble(subString);
            if (currentValue <= pvalue) {
                answer++;
            }
        }
        return answer;
    }
}