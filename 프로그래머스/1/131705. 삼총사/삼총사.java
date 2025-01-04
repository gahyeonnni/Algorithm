import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        for (int i = 0; i < number.length; i++){
            int x = number[i];
            int plusX = i + 1;
            while (plusX < number.length - 1) {
                int o = x + number[plusX];
                if (o > number[number.length - 1]) {
                    plusX++;
                    if (plusX == number.length - 1)
                        break;
                } 
                else {
                    for (int j = plusX + 1; j < number.length; j++) {
                        if (o + number[j] == 0)
                            answer++;
                    }
                    plusX++;
                }
            }
        }
        return answer;
    }
}