import java.io.*;
import java.util.*; 

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
         while (n > 0) {
            int a = n % 3;
            n = n / 3;

            if (a == 0) {
                a = 4;
                n--; 
            }

            answer.insert(0, a); 
        }

        
        return answer.toString();
    }
}