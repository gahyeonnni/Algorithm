import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        return BFS(begin, target, words, visited);
    }

    private static int BFS(String a, String b, String[] words, boolean[] visited) {
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>(); 
        
        queue.add(a);
        depthQueue.add(0);
        
        while (!queue.isEmpty()) {
            String x = queue.poll();
            int depth = depthQueue.poll(); 
            
            if (x.equals(b)) 
                return depth; 
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int diff = 0;
                    for (int j = 0; j < x.length(); j++) {
                        if (x.charAt(j) != words[i].charAt(j))
                            diff++;
                        if (diff > 1) break;
                    }
                    
                    if (diff == 1) { 
                        visited[i] = true;
                        queue.add(words[i]);
                        depthQueue.add(depth + 1); 
                    }
                }
            }
        }
        return 0; 
    }
}
