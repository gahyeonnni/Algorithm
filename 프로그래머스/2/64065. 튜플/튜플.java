import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] num = s.split("[{}]+");
        String x = "";
        int max = 0;

        for (int i = 0; i < num.length; i++) {
            if (!num[i].isEmpty()) {
                String [] number = num[i].split(",");
                if (number.length > max) {
                    max = number.length;
                    x = num[i];
                }
            }
        }
        
        String [] ans = new String [max];
        int index = 0; 
        int [] answer = new int [max];
        
        for (int i = 0; i < num.length; i++){
           if (!num[i].isEmpty()) {
                String o = num[i];
               if (o.equals(","))
                   continue;
               else
                   ans[index++] = o;
            } 
        }
        
        Arrays.sort(ans, Comparator.comparingInt(String::length));
         Set<Integer> hashset = new LinkedHashSet<>();
        
        for (int i = 0; i < ans.length; i++){
            String [] number = ans[i].split(",");
            for (int j = 0; j < number.length; j++){
                hashset.add(Integer.parseInt(number[j]));
            }
        }
        
        int ind = 0;
        for (int km : hashset){
           answer[ind++] = km; 
        }
        
        return answer;
    }
}
