import java.io.*;
import java.util.*;

public class Solution {
	static String answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	int n = Integer.parseInt(br.readLine()); 
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] array = new int [7]; 
        	for (int i = 0; i < 7; i++)
        		array[i] = Integer.parseInt(st.nextToken());  
        	int answer = Integer.MAX_VALUE;
        	for (int start = 0; start < 7; start++) {
        		int day = 0; 
        		int count = 0; 
        		int now = start; 
        		
        		while (count < n) {
            		int k = now % 7; 
            		if (array[k] == 1) {
            			count++;
            		}
            		now++;
            		day++;
            	}
        		 answer = Math.min(answer, day);
        	}
            System.out.println("#" + (j + 1) + " " + answer);
        }
    }
}
