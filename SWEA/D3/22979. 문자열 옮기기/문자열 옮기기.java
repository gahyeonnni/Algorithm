import java.io.*;
import java.util.*;

public class Solution {  
	static String delfirst(String s, int a) {
		a = a % s.length();
		String first = s.substring(0, a); 
		s = s.substring(a); 
		s += first;
		return s;
	}
	static String delfinal(String s, int a) { 
		a = Math.abs(a) % s.length();
		String ans = ""; 
		int k = s.length();
		String finals = s.substring(k - a); 
		ans += finals; 
		s = s.substring(0, k - a);
		ans += s; 
		s = ans;
		return s;
	}
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < t; i++) {
        	String s = br.readLine(); 
        	int k = Integer.parseInt(br.readLine()); 
        	int [] array = new int [k];
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	for (int p = 0; p < k; p++) {
        		array[p] = Integer.parseInt(st.nextToken());
        	} 
        	for (int j = 0; j < k; j++) {
        		int a = array[j];  
        		if (a > 0) {
        			s = delfirst(s, a);
        		}
        		else if (a < 0) {
        			s = delfinal(s, a);
        		}
        		else {
        			continue;
        		}
        	} 
        	System.out.println(s);
        }

    }
}
