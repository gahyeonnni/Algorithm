import java.io.*; 
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int len = phone_book.length;
        for (int i = 0; i < len - 1; i++) {
            String s1 = phone_book[i]; 
            String s2 = phone_book[i + 1]; 
            if (s2.startsWith(s1))
                answer = false;
        }
        return answer;
    }
}