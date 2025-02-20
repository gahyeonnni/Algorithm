import java.util.*;

class Solution {
    private static String [] alpha = {"A", "E", "I", "O", "U"};
    public static void make(int a, List <String> list, String x){
        if (a >= 5)
            return;
        for (int i = 0; i < alpha.length; i++){
            list.add( x + alpha[i]);
            make(a + 1, list, x + alpha[i]);
        }
    }
    public int solution(String word) {
        int answer = 0;
        List <String> list = new LinkedList<>();
        String x = "";
        make(0, list, x);
        answer = list.indexOf(word) + 1;
        return answer;
    }
}