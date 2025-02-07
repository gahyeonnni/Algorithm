import java.util.*;

class Solution {
    
    //소수 판별 함수
    private static boolean isPrime(int a){
        if (a < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(a); i++){
            if (a % i == 0)
                return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        HashSet<Integer> num = new HashSet<>();
        boolean [] visited = new boolean [numbers.length()];
        
        makenum("", numbers, visited, num);
        
        int answer = 0;
        
        for (int n : num){
            if (isPrime(n))
                answer++;
        }
            
        return answer;
      }
    
    private void makenum(String x, String numbers, boolean [] visited, HashSet<Integer> num){
        if (!x.isEmpty()){
            num.add(Integer.parseInt(x));
        }
        
        for (int i = 0; i < visited.length; i++){
            if (!visited[i]){
                visited[i] = true;
                makenum(x + numbers.charAt(i), numbers, visited, num);
                visited[i] = false;
            }
        }
    }
}