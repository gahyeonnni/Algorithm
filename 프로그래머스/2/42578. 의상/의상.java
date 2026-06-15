import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;  
        HashMap<String, List <String>> map = new HashMap<>();
        for (String [] clothe : clothes) {
            String name = clothe[0]; 
            String type = clothe[1];
            List<String> list = map.getOrDefault(type, new ArrayList<>()); 
            list.add(name); 
            map.put(type, list);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key); 
            answer *= (list.size() + 1);
        }
        return answer - 1;

    }
}