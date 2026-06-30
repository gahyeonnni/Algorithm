import java.io.*; 
import java.util.*; 

class Solution {
    static int count(int start, List<List<Integer>> list, boolean [] check) {
        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true; 
        int total = 0;
        
        while (!queue.isEmpty()) {
            int q = queue.poll(); 
            total++;
            for (int a : list.get(q)) {
                if (!check[a]) {
                    queue.add(a); 
                    check[a] = true;
                }
            }
        }
        
        return total;
    }
    
    static int diff(List<List<Integer>> list, int n, int start, int finish) {
        boolean [] check = new boolean [n + 1]; 
        check[finish] = true;
        int half1 = count(start, list, check);
        
        boolean [] check2 = new boolean [n + 1]; 
        check2[start] = true;
        int half2 = count(finish, list, check2);
        
        if (half1 + half2 != n)
            return Integer.MAX_VALUE;
        
        return Math.abs(half1 - half2);
        
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>(); 
        for (int i = 0; i < n + 1; i++){
            list.add(new ArrayList<>()); 
        }
        
        for (int [] wire : wires)  {
            int start = wire[0]; 
            int finish = wire[1]; 
            list.get(start).add(finish);
            list.get(finish).add(start);
        }

        for (int i = 0; i < n + 1; i++) {
            List <Integer> lis = list.get(i); 
            if (lis.size() == 0)
                continue; 
            
            for (int a : lis)
                answer = Math.min(answer, diff(list, n, i, a));
        }
        
        return answer;
    }
}