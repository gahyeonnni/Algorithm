import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        List <Integer> list = new ArrayList<>();
        
        for (int [] tri : triangle) {
            if (tri.length == 1) {
                list.add(tri[0]);  
                continue;
            }
            
            int last = list.size() - 1; 
            list.add(list.get(last) + tri[tri.length - 1]); 
            
            for (int i = tri.length - 2; i > 0; i--) {
                int max = Math.max(list.get(i - 1), list.get(i)); 
                list.set(i, max + tri[i]);
            }
             
            list.set(0, list.get(0) + tri[0]);
        }
        
        for (int k : list)
            answer = Math.max(k, answer);
        
        return answer;
    }
}