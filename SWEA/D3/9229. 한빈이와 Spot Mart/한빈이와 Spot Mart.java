import java.io.*;
import java.util.*;

public class Solution {
	static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	answer = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	int n = Integer.parseInt(st.nextToken()); 
        	int m = Integer.parseInt(st.nextToken()); 
        	int [] array = new int [n]; 
        	st = new StringTokenizer(br.readLine()); 
        	for (int i = 0; i < n; i++)
        		array[i] = Integer.parseInt(st.nextToken()); 
        	Arrays.sort(array); 
        	int left = 0; 
        	int right = n - 1; 
        	while (left < right) {
        		int sum = array[left] + array[right]; 
        		if (sum > m)  {
        			right--;
        		}
        		else if (sum <= m) {
        			answer = Math.max(sum, answer); 
        			left++;
        		}
        	}
        	if (answer == 0)
        		answer = -1; 
        	System.out.println("#" + (j + 1) + " " + answer);
        }
    }
}
