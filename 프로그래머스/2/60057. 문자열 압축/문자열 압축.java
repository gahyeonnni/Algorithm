import java.io.*; 
import java.util.*; 

class Solution {
    static int makeNewString(String s, int wordlen) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(i, Math.min(s.length(), i + wordlen)); 
            int count = 0;
            for (int j = i + wordlen; j < s.length(); j += wordlen) {
                String k = s.substring(j, Math.min(s.length(), j + wordlen));
                if (k.equals(first)) {
                    count++;
                    continue;
                }
                break;
            }
            if (count != 0)
                newString += String.valueOf(count + 1); 
            newString += first; 
            i += (count + 1) * wordlen - 1; 
        }
        return newString.length();
    }
    public int solution(String s) {
        if (s.length() == 1) 
            return 1;
        int answer = Integer.MAX_VALUE; 
        int mid = s.length() / 2;
        int count = 1;
        while (count <= mid) {
            int len = makeNewString(s, count); 
            answer = Math.min(answer, len);
            count+=1;
        }
        return answer;
    }
}