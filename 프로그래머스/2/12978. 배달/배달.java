import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List <List <int []>> list = new ArrayList<>(); 
        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>()); 
        
        for (int [] x : road) {
            int a = x[0]; 
            int b = x[1]; 
            int c = x[2]; 
            
            list.get(a).add(new int [] {b, c}); 
            list.get(b).add(new int [] {a, c}); 
        }

        int [] dist = new int [N + 1]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[1] = 0;
        PriorityQueue <int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int [] {1, 0});
        
        while (!pq.isEmpty()) {
            int [] cur = pq.poll(); 
            int a = cur[0]; 
            int b = cur[1]; 
        
            if (b > K)
                continue; 
            
            for (int [] x : list.get(a)) {
                int p = x[0]; 
                int q = x[1]; 
                if (dist[p] > q + b) {
                    dist[p] = q + b; 
                    pq.add(new int [] {p, dist[p]});
                }
            }
        }
        
        for (int i  = 0; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }
        return answer;
    }
}