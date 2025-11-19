import java.io.*;
import java.util.*;

public class Solution {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { 
            String s = br.readLine(); 
            HashMap<String, List<Integer>> map = new HashMap<>();
            String ans = "yes";  
            if (s.charAt(0) == '0') {
            	ans = "no"; 
            	System.out.println(ans);
            	continue;
            }
            for (int j = 0; j < s.length(); j++) {
                String k = s.substring(j, j + 1);  
                if (!map.containsKey(k)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    map.put(k, list);
                } else { 
                    List<Integer> newcur = new ArrayList<>(map.get(k));  
                    newcur.add(j);
                    map.put(k, newcur);
                }
            }

            for (String a : map.keySet()) {
                int num = Integer.parseInt(a); 
                List<Integer> x = map.get(a);

                if (num < 0 || num > 9) { 
                    ans = "no";
                    break;
                }

                if (x.size() > 2) {
                    ans = "no"; 
                    break;
                } 
                else if (x.size() == 2) {
                    int p = x.get(0); 
                    int q = x.get(1);
                    if ((Math.abs(p - q) - 1) != num) {
                        ans = "no"; 
                        break;
                    }
                } 
                else {
                	ans = "no"; 
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
