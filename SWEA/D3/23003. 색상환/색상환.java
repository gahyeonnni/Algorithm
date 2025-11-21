import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        HashMap <String, List <String>> map = new HashMap<>(); 
        map.put("red", new ArrayList<>(Arrays.asList("purple", "orange", "green")));
        map.put("orange", new ArrayList<>(Arrays.asList("red", "yellow", "blue")));
        map.put("yellow", new ArrayList<>(Arrays.asList("green", "orange", "purple")));
        map.put("green", new ArrayList<>(Arrays.asList("yellow", "blue", "red")));
        map.put("blue", new ArrayList<>(Arrays.asList("purple", "green", "orange")));
        map.put("purple", new ArrayList<>(Arrays.asList("blue", "red", "yellow")));

        for (int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	String answer;
        	String s = st.nextToken(); 
        	String x = st.nextToken(); 
        	if (s.equals(x))
        		answer = "E";
        	else {
        		List<String> cur = map.get(s); 
        		String a = cur.get(0); 
        		String b = cur.get(1); 
        		String c = cur.get(2); 
        		if (x.equals(c)) {
        			answer = "C";
        		}
        		else if (x.equals(a) || x.equals(b))
        			answer = "A"; 
        		else 
        			answer = "X";
        	}
        	System.out.println(answer);
        }
    }
}
