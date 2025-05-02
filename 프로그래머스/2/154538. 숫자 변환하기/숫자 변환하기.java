import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    
    private void BFS(int x, int y, int n, int cnt) {
        Queue <int []> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
    
        queue.add(new int[]{x, cnt});
        visited.add(x);
        
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int num = a[0];
            int count = a[1];
            
            if (num == y) {
                min = Math.min(min, count);
                return;
            }
            
            int[] nexts = {num + n, num * 2, num * 3};
            for (int next : nexts) {
                if (next <= y && !visited.contains(next)) {
                    visited.add(next);
                    queue.add(new int[]{next, count + 1});
                }
            }
        }
    }

    public int solution(int x, int y, int n) {
        BFS(x, y, n, 0);
        if (min == Integer.MAX_VALUE)
            return -1;
        else 
            return min;
    }
}
