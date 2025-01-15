import java.io.*;
import java.util.*;

class Solution {
    private int[] index1 = {1, 2, 3, 4, 5};
    private int[] index2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] index3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    private int answer1 = 0;
    private int answer2 = 0;
    private int answer3 = 0;
    
    public int[] solution(int[] answers) {
        
        int x = answers.length;
        
        for (int i = 0; i < answers.length; i++) {
            int a1 = i % 5;
            int a2 = i % 8;
            int a3 = i % 10;
            
            if (answers[i] == index1[a1])
                answer1++;
            if (answers[i] == index2[a2])
                answer2++;
            if (answers[i] == index3[a3])
                answer3++;
        }
        
        int[] result = new int[3];
        int index = 0;

        int maxScore = Math.max(answer1, Math.max(answer2, answer3));

        if (answer1 == maxScore) result[index++] = 1;
        if (answer2 == maxScore) result[index++] = 2;
        if (answer3 == maxScore) result[index++] = 3;

        return Arrays.copyOf(result, index);
    }
}
