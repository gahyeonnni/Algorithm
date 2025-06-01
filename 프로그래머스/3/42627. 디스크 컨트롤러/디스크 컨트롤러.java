import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = jobs[i][0];  
            arr[i][1] = jobs[i][1];  
            arr[i][2] = i;           
        }
        
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            }
        );

        int current = 0;
        int total = 0;
        int idx = 0;  
        while (idx < n || !pq.isEmpty()) {
            while (idx < n && arr[idx][0] <= current) {
                pq.offer(arr[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                current = arr[idx][0];
                continue;
            }

            int[] job = pq.poll();
            int a = job[0];
            int b = job[1];
            current += b;                                 
            total += (current - a);          
        }

        return total / n;
    }
}
