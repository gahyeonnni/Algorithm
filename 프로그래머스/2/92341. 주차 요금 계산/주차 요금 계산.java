import java.io.*; 
import java.util.*;

class Solution {
    private int minutes(String hhmm) {
        String [] h = hhmm.split(":"); 
        return Integer.parseInt(h[0]) * 60 + Integer.parseInt(h[1]);
    }
    
    public int[] solution(int[] fees, String[] records) {;
        HashMap <String,  List<String>> rec = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] parts = records[i].trim().split("\\s+");
            String time = parts[0];    
            String car = parts[1];      
            rec.computeIfAbsent(car, k -> new ArrayList<>()).add(time);
        }
        
        HashMap <String, Integer> timeadd = new HashMap<>();
        for (Map.Entry<String, List<String>> e : rec.entrySet()) {
            String carNo = e.getKey();
            List<String> times = e.getValue();
            if (times.size() % 2 == 1) 
                times.add("23:59");
            int total = 0;
            for (int i = 0; i < times.size(); i += 2) {
                int in  = minutes(times.get(i));
                int out = minutes(times.get(i + 1));
                total += out - in;
            }
            timeadd.put(carNo, total);
        }
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        TreeMap<String, Integer> sorted = new TreeMap<>(timeadd);
        int[] answer = new int[sorted.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> e : sorted.entrySet()) {
            int t = e.getValue();
            int fee;
            if (t <= baseTime) {
                fee = baseFee;
            } else {
                int extra = t - baseTime;
                int units = (extra + unitTime - 1) / unitTime;
                fee = baseFee + units * unitFee;
            }
            answer[idx++] = fee;
        }
        return answer;
    }
}