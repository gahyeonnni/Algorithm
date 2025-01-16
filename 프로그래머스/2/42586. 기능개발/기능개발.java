import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progress, int[] speeds) {
        int[] answer = new int [progress.length];
        int [] result = new int [progress.length];
        
        int num = 0;
        for (int key : progress){
            int a = 0;
            int b = speeds[num];
            while (key < 100) {
                key += b;
                a++;
            }
            result[num] = a;
            num++;
        }
        
        int n = 0;
        int i = 0;

        while (i < result. length) {
            int x = 1;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] <= result[i]) {
                    x++;
                }
                else
                    break;
            }
            answer[n] = x;
            n++;
            i = i + x;
        }
        
        int[] answer2 = Arrays.copyOf(answer, n);
        return answer2;
    }
}