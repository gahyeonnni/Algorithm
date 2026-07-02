import java.io.*; 
import java.util.*; 

class Solution {
    static List <List <int []>> list;
    
    static boolean allArrive(boolean[] check) {
        for (boolean k : check) {
            if (!k) {
                return false; 
            }
        }
        return true; 
    }
    
    static int totalCount(int start, boolean [] check, int sum) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        queue.add(new int [] {start, 0});
        
        while (!queue.isEmpty()) {
            if (allArrive(check))
                return sum;
            
            int[] current = queue.poll();
            int q = current[0];
            int cost = current[1];
            
            if (check[q]) 
                continue;
            
            check[q] = true;
            sum += cost;
            
            for (int [] lis : list.get(q)) {
                int a = lis[0]; 
                int b = lis[1]; 
                
                if (!check[a]) {
                    queue.add(new int [] {a,b});
                }
            }
            
        }
        
        if (!allArrive(check))
            return Integer.MAX_VALUE; 
        
        return sum;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = Integer.MAX_VALUE; 
        list = new ArrayList<>(); 
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        
        for (int [] cost : costs) {
            int start = cost[0]; 
            int dest = cost[1];
            int count = cost[2]; 
            list.get(start).add(new int [] {dest, count});
            list.get(dest).add(new int [] {start, count});
        }
        
        for (int i = 0; i < n; i++) {
            boolean [] check = new boolean [n];
            answer = Math.min(answer, totalCount(i, check, 0));
        }
            
        return answer;
    }
}