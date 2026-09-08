import java.io.*; 
import java.util.*; 

class Solution {
    static int basic = 540;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        List <Integer> sutimes = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            sutimes.add(basic + i * t);
        }
        
        Queue <Integer> times = new LinkedList<>(); 
        for (String ti : timetable) {
            String [] s = ti.split(":"); 
            int k = Integer.valueOf(s[0]) * 60 + Integer.valueOf(s[1]); 
            times.add(k);
        }
        
        for (int i = 0; i < sutimes.size(); i++) {
            int sutime = sutimes.get(i);
            int count = 0; 
            int last = 0; 
            
            for (int j = 0; j < m; j++) {
                if (times.isEmpty())
                    break;
                int q = times.peek();
                if (q <= sutime) {
                    last = times.poll(); 
                    count++;            
                } else {
                    break; 
                }
            }
            if (i == sutimes.size() - 1) {
                int k = 0;
                
                if (count == m) {
                    k = last - 1;
                } else {
                    k = sutime;
                }

                answer = String.format("%02d:%02d", k / 60, k % 60);
            }
        } 
        
        return answer;
    }
}