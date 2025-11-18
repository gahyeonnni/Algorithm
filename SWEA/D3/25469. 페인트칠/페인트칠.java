import java.io.*;
import java.util.*;

public class Solution {   
	static boolean same(String [] x) {
		String k = x[0];  
		if (!k.equals("#"))
			return false;
		for (int i = 1; i < x.length; i++) {
			if (!k.equals(x[i]))
				return false;
		}
		return true;
	}
	static int howNum(String [][] array) {
		int ans = 0; 
		int n = array.length; 
		int m = array[0].length;
		for (int i = 0; i < n; i++) {
			String [] x = array[i];
			if (same(x))
				ans++;
		} 
		if (ans == n)
			return Math.min(n, m); 
		for (int i = 0; i < m; i++) {
            String [] x = new String[n];
            for (int j = 0; j < n; j++) {
                x[j] = array[j][i];  
            }
            if (same(x))
                ans++;
        }
		return ans;
	}
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int num = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < num; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	int a = Integer.parseInt(st.nextToken()); 
        	int b = Integer.parseInt(st.nextToken()); 
        	String [][] array = new String [a][b];  
        	for (int j = 0; j < a; j++) {
        		String x = br.readLine(); 
        		for (int m = 0; m < x.length(); m++) {
        			array[j][m] = x.substring(m, m + 1);
        		}
        	}
        	int count = howNum(array);
        	System.out.println(count);
        }
    }
}
