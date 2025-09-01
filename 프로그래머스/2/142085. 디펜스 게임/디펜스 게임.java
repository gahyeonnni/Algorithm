import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0; 
        PriorityQueue<Integer> survive = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : enemy) {
            survive.add(a); 
            n -= a; 
            
            if (n < 0) {
                if (k > 0) {
                    k--; 
                    n += survive.poll();
                }
                else 
                    break;
            }
            answer++;
            
        }
        return answer;
    }
}