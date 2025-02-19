import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int a = brown + yellow;
        for (int i = 2; i < (a / 2); i++){
            if (a % i == 0){ 
                int b = a / i; //가로 
                if (i - 2 > 0 && b -2 > 0 && (i -2) * (b - 2) == yellow){
                    answer[0] = i;
                    answer[1] = b;
                }
            }
        }
        return answer;
    }
}