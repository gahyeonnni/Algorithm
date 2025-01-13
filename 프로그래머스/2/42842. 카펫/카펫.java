import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        
        int a = 0;
        int b = 0;
        int text = brown + yellow;
        
        for (int i = 1; i < text / 2; i++){ 
            if (text % i == 0){
                if (i * 2 + 2 * (text / i - 2) == brown){
                    a = i;
                    b = text / i;
                } 
            }
        }
        
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}