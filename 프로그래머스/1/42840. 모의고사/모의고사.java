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
        int [] ans = new int [3];
        ans[0] = answer1;
        ans[1] = answer2;
        ans[2] = answer3;
        
        int maxnum = 0;
        maxnum = Math.max(answer1, Math.max(answer2, answer3));
        
        List <Integer> list = new LinkedList<>();
        for (int i = 0; i < ans.length; i++){
            if (ans[i] == maxnum)
                list.add(i+1);
        }
        
        int [] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
