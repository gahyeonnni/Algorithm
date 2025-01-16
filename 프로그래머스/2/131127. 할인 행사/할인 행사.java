import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap <String, Integer> firstmap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            firstmap.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++){
            int count = 10;
            int num = i;
            int sum = 0;
            HashMap<String, Integer> map = new HashMap<>(firstmap);
            while (count-- > 0) {
                String x = discount[num];
                if (map.containsKey(x)){
                    int va = map.get(x) - 1;
                   if (va > 0) {
                        map.put(x, va);
                    } 
                    else {
                        map.remove(x); 
                    }
                }
                num++;
            }
            for (String key : map.keySet()){
                sum += map.get(key);
            }
            if (sum == 0)
                answer++;
        }
        return answer;
    }
}