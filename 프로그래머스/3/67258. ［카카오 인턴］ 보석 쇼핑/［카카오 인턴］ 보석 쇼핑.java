import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> gemsnum = new HashSet<>(Arrays.asList(gems));
        int n = gemsnum.size(); 

        HashMap <String, Integer> check = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int right = 0; right < gems.length; right++) {
            String gem = gems[right];
            check.put(gem, check.getOrDefault(gem, 0) + 1);
            
            while (check.size() == n) {
                
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                    end = right;
                }
                
                String leftGem = gems[left];
                if (check.get(leftGem) == 1) {
                    check.remove(leftGem);
                } 
                else {
                    check.put(leftGem, check.get(leftGem) - 1);
                }
                left++;
            }
        }

        answer[0] = start + 1;
        answer[1] = end + 1;
        return answer;
    }
}
