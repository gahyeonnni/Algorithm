import java.util.*;

class Solution {
    private static int answer = 0;
    public int solution(int[] nums) {
        HashSet <Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }
        System.out.println(hash.size());
        System.out.println(nums.length / 2);
        if (hash.size() > (nums.length / 2)) {
            int a =(nums.length / 2) - hash.size();
            System.out.println(a);
            return hash.size() + a;
        }
        return hash.size();
    }
}