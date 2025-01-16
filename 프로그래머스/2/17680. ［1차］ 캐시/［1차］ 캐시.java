import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0)
            return cities.length * 5; 
        
        Map <String, Integer> hashmap = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        
        for (String city : cities){
            city = city.toLowerCase();
            
            if (hashmap.containsKey(city)){
                answer += 1; 
                list.remove(city);
                list.add(city);
            }
            else {
                answer += 5; 
                
                if (list.size() == cacheSize){
                    String old = list.removeFirst();
                    hashmap.remove(old);
                }
                list.add(city);
                hashmap.put(city, 1);
            }
        }
        return answer;
    }
}