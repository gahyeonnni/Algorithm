import java.util.*;

class Solution {
    private static int [] answer1 = {1, 2, 3, 4, 5}; //5개
    private static int [] answer2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8개
    private static int [] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10개
    
    private static int ans1 = 0;
    private static int ans2 = 0;
    private static int ans3 = 0;
    
    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++){
            int a1 = i % 5;
            int a2 = i % 8;
            int a3 = i % 10;
            
            if (answer1[a1] == answers[i])
                ans1++;
            if (answer2[a2] == answers[i])
                ans2++;
            if (answer3[a3] == answers[i])
                ans3++;
        }
        int a = Math.max(ans1, Math.max(ans2, ans3));
        List <Integer> list = new LinkedList<>();
        if (a == ans1)
            list.add(1);
        if (a == ans2)
            list.add(2);
        if (a == ans3)
            list.add(3);
        int[] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}