import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String [] num = new String [numbers.length];
        for (int i = 0; i < num.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (a,b) -> (b+a).compareTo(a+b));
        
        int index = 0;
        if (num[0].equals("0")) {
            return String.valueOf(0);
        }
        
        for (int i = 0; i < num.length; i++){
                answer += num[i];
        }
        return answer;
    }
}