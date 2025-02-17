import java.util.*;

class Solution {
    private static int answer = 0;
    private static HashSet <Integer> hash;
    
    private static boolean find (int a){
        if (a < 2)
            return false;
        
        for (int i = 2; i <= Math.sqrt(a); i++){
            if (a % i == 0)
                return false;
        }
        
        return true;
    }
    
    private static void CHECK (String num, boolean [] a, String x) {
        if (!x.isEmpty()){
            hash.add(Integer.parseInt(x));
        }
        
        for (int i = 0; i < num.length(); i++){
            if (!a[i]){
                a[i] = true;
                CHECK(num, a, x + num.charAt(i));
                a[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        hash = new HashSet<>();
        boolean [] nums = new boolean [numbers.length()];
        String x = "";
        CHECK(numbers, nums, x);
        for (int b : hash){
            if (find(b)){
                 answer++;
            }
        }
        return answer;
    }
}