import java.io.*;
import java.util.*; 

class Solution { 
    
    static boolean oneWordChange(String begin, String target) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i))
                count++;
        }
        if (count == 1)
            return true; 
        else 
            return false;
    }
    
    static int bfs(String begin, String target, String[] words, boolean[] check) {
        Queue<String> queue = new LinkedList<>(); 
        queue.add(begin); 
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            
            for (int s = 0; s < size; s++) {
                String x = queue.poll();
                
                if (x.equals(target))
                    return count; 
                
                for (int i = 0; i < words.length; i++) {
                    if (!check[i]) {
                        String word = words[i]; 
                        if (oneWordChange(x, word)) {
                            queue.add(word); 
                            check[i] = true; 
                        }
                    }
                }
            }
            count++; 
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        if (!java.util.Arrays.asList(words).contains(target)) 
            return 0; 
        
        boolean[] check = new boolean[words.length];
        
        return bfs(begin, target, words, check);
    }
}