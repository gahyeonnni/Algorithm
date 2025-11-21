import java.io.*;
import java.util.*;

public class Solution {
	static String answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	int answer = 0;
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	Map <Integer, Integer> map  =new HashMap<>(); 
        	for (int i = a; i <= b; i++) {
        		map.put(i, map.getOrDefault(i, 0) + 1);
        	}
        	for (int i = c; i <= d; i++) {
        		map.put(i, map.getOrDefault(i, 0) + 1);
        	} 
        	for (int k : map.keySet()) {
        		if (map.get(k) == 2) 
        			answer++;
        	} 
        	if (answer != 0)
        		answer--;
        	System.out.println("#" + (j + 1) + " " + answer);
        }
    }
}
