import java.util.*;

class Solution {
    static List<String> candidates = new ArrayList<>();

    static void makeNumber(String number, int k, int start, String s) {
        if (k == 0) {
            candidates.add(s + number.substring(start));
            return;
        }
     
        if (start >= number.length()) 
            return;

        makeNumber(number, k - 1, start + 1, s);
        makeNumber(number, k, start + 1, s + number.charAt(start));
    }

    public String solution(String number, int k) {
        candidates.clear();
        makeNumber(number, k, 0, "");

        String answer = candidates.get(0);
        for (String cand : candidates) {
            if (cand.compareTo(answer) > 0) 
                answer = cand;
        }
        return answer;
    }
}