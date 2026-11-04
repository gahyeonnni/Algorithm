import java.io.*; 
import java.util.*; 

class Solution {
    static Set<Integer> allnums;
    static boolean[] visited;
    static int[] num;
    
    static boolean isPrime(int n) {
        if (n < 2)
            return false; 
        
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false; 
        
        return true;
    }
    
    static void makenum(int cur) {
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) 
                continue;
            
            visited[i] = true;
            int next = cur * 10 + num[i];
            allnums.add(next);  
            makenum(next);       
            visited[i] = false; 
        }
    }
    
    public int solution(String numbers) {
        allnums = new HashSet<>();
        num = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) - '0';
        }
        
        makenum(0);
        
        int answer = 0;
        for (int n : allnums) {
            if (isPrime(n)) 
                answer++;
        }

        return answer;
    }
}