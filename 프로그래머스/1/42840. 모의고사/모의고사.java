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
            
            if (index1[a1] == answers[i])
                answer1++;
            if (index2[a2] == answers[i])
                answer2++;
            if (index3[a3] == answers[i])
                answer3++;
        }
        
        int [] answer = {};
        if (answer1 == answer2 && answer2 == answer3){
            answer=  new int [3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }
        
        if (answer1 == answer2 && answer2 > answer3){
            answer = new int [2];
            answer[0] = 1;
            answer[1] = 2;
        }
        
        if (answer1 == answer3 && answer1 > answer2){
            answer = new int [2];
            answer[0] = 1;
            answer[1] = 3;
        }
        
        if (answer2 == answer3 && answer2 > answer1){
            answer = new int [2];
            answer[0] = 2;
            answer[1] = 3;
        }
        
        if (answer1 > answer2 && answer1 > answer3){
            answer = new int [1];
            answer[0] = 1;
        }
        
        if (answer2 > answer3 && answer2 > answer1){
            answer = new int [1];
            answer[0] = 2;
        }
        
        if (answer3 > answer1 && answer3 > answer2){
            answer = new int [1];
            answer[0] = 3;
        }
        return answer;
    }
}
