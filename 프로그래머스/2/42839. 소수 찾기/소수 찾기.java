import java.io.*;
import java.util.*;

class Solution {
    private Set<Integer> b = new HashSet<>();
    private int answer = 0;
    
    public int isPrime(int n){
        if (n <= 1)
            return 0;
        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0)
                return 0;
        }
        return 1;
    }
    
    public void BFS(String [] s,  String x, boolean [] used){
        if (!x.isEmpty()) {
            b.add(Integer.parseInt(x));
        }
        for (int i = 0; i < s.length; i++){
            if (!used[i]){
                used[i] = true;
                BFS(s,x + s[i],used);
                used[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        String [] s = numbers.split("");
        boolean[] used = new boolean [s.length];
        BFS(s, "", used);
        for (int n : b){
            if (isPrime(n) == 1) {
                answer++;
            }
        }
        return answer;
    }
}
