import java.io.*; 
import java.util.*; 

class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];  
        
        Map<String, String> people = new HashMap<>(); 
        Map<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String currentPerson = seller[i];
            int money = amount[i] * 100;
            
            while (true) {
                int money10 = money / 10;        
                int mine = money - money10;       
                
                answer[indexMap.get(currentPerson)] += mine;
                
                String parent = people.get(currentPerson);
                money = money10;
                
                if (parent == null || parent.equals("-") || money == 0) {
                    break;
                }
                
                currentPerson = parent;
            }
        }
        
        return answer;
    }
}