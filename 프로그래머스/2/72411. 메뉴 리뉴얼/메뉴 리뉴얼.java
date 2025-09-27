import java.io.*; 
import java.util.*; 

class Solution {
    static Map<String, Integer> counter = new HashMap<>();

    static void makemix(String [] orders, int a) {
       for (String order : orders) {
           if (order.length() >= a) {
               char[] arr = order.toCharArray();
               Arrays.sort(arr);
               makenum(new String(arr), a, 0, new StringBuilder());
           }
       }
    }
    
    static void makenum(String order, int a, int idx, StringBuilder sb) {
        if (sb.length() == a) {
            String word = sb.toString(); 
            counter.put(word, counter.getOrDefault(word, 0) + 1);
            return;
        }
        
        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            makenum(order, a, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List <String> result = new ArrayList<>();
        for (int num : course) {
            counter.clear(); 
            makemix(orders, num); 
            
            int max = 0; 
            for (int a : counter.values()) {
                max = Math.max(max, a);
            }
            
            if (max >= 2) {
                for (String key : counter.keySet()) {
                    if (counter.get(key) == max) {
                        result.add(key);
                    }
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}