import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int num = Integer.parseInt(br.readLine());  
    	List <int []> list = new ArrayList<>();
    	for (int i = 0; i < num; i++) {
    		String s = br.readLine();  
    		int year = Integer.parseInt(s.substring(0, 4));
    		int month = Integer.parseInt(s.substring(4, 6)); 
    		int day = Integer.parseInt(s.substring(6));   
    		list.add(new int [] {year, month, day});
    	}
    	int index = 1; 
    	for (int [] x : list) { 
    		int answer = 0;
    		int y = x[0];
    		int m = x[1]; 
    		int d = x[2]; 
    		if (m < 1 || m > 12)
    			answer = -1;  
    		else if (m == 2) {
    			if (d < 1 || d > 28)
    				answer = -1;
    		}
    		else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
    			if (d < 1 || d > 31)
    				answer = -1;
    		}
    		else if (m == 4 || m == 6 || m == 9 || m == 11) {
    			if (d < 1 || d > 30)
    				answer = -1;
    		}
    		if (answer == -1) {
    			System.out.println("#" + index + " " + answer);
    			index++;
    		} 
    		else { 
    			String s = String.valueOf(y); 
    			String yearc = "";
    			int rem = 0; 
    			if (s.length() != 4) {
    				rem = 4 - s.length();
    			}
    			int k = 0;
    			while (k != rem) {
    				k++; 
    				yearc += "0";
    			}
    			yearc += y; 
    			String p = String.valueOf(m); 
    			if (p.length() != 2) {
    				rem = 2 - p.length();
    			}
    			String mc = "";
    			while (rem-- > 0) {
    				mc += "0";
    			}
    			mc += m; 
    			p = String.valueOf(d); 
    			if (p.length() != 2) {
    				rem = 2 - p.length();
    			}
    			String dc = "";
    			while (rem-- > 0) {
    				dc += "0";
    			}
    			dc += d; 
    			System.out.println("#" + index + " " + yearc + "/" + mc + "/" + dc);
        		index++; 
    		}
    	}
    }
}
