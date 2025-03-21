import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> check = new HashMap<>();
        
        for (int t : topping) {
            total.put(t, total.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];

            check.put(t, check.getOrDefault(t, 0) + 1);

            total.put(t, total.get(t) - 1);
            if (total.get(t) == 0) 
                total.remove(t);

            if (total.size() == check.size()) 
                answer++;
        }

        return answer;
    }
}
