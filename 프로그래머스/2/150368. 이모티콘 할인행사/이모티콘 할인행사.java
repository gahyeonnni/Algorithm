import java.io.*; 
import java.util.*; 

class Solution {
    static int [] discountrate = {10,20,30,40};
    static int[] answer;
    static void discountmix(int m, List <Integer> put, int[][] users, int[] emoticons) {
        if (put.size() == m) {
            int people = 0;
            int cost = 0;
            
            for (int [] u : users) {
                int needRate = u[0];  
                int limit = u[1];    
                int sum = 0;
                
                for (int k = 0; k < m; k++) {
                    int r = put.get(k); 
                    if (r >= needRate) {
                        sum += emoticons[k] * (100 - r) / 100;
                    }
                }
                
                if (sum >= limit) 
                    people++; 
                else 
                    cost += sum;
            }
            
            if (people > answer[0] || (people == answer[0] && cost > answer[1])) {
                answer[0] = people;
                answer[1] = cost;
            }
            return;
        }
        
        for (int rate : discountrate) {
            put.add(rate);
            discountmix(m, put, users, emoticons);
            put.remove(put.size() - 1);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int [2]; 
        List <Integer> put = new ArrayList<>();
        discountmix(emoticons.length, put, users, emoticons);
        return answer;
    }
}