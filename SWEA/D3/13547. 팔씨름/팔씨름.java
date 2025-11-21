import java.io.*;
import java.util.*;

public class Solution {
	static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	String s = br.readLine(); 
        	int sum = 0;
        	for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) == 'x') {
        			sum++;
        		}
        	}
        	if (sum > 7)
        		answer = "NO";
        	else
        		answer = "YES";
        	System.out.println("#" + (j + 1) + " " + answer);
        }
    }
}
