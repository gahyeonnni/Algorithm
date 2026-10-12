import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length / 2;
        HashMap<Integer, Integer> numandcount = new HashMap<>(); 
        for (int n : nums) {
            numandcount.put(n, numandcount.getOrDefault(n, 0) + 1);
        }
                
        if (numandcount.size() == half)
            answer = half;
        else if (numandcount.size() < half)
            answer = numandcount.size();
        else 
            answer = half;
        
        return answer;
    }
}