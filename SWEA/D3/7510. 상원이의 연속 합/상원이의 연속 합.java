import java.io.*;
import java.util.*;

public class Solution {   
	
	static int sum(int [] array, int a, int b) {
		int s = 0;
		for (int i = a; i <= b; i++) {
			s += array[i];
		}
		return s;
	}
	
	static int make(int n) {
		int [] array = new int [n];
		for (int i = 0; i < n; i++)
			array[i] = i + 1; 
		int left = 0; 
		int right = 0; 
		int ans = 0;
		while (right < n) {
			int s = sum(array, left, right); 
			if (s == n) {
				ans++; 
				left++;
			} 
			else if (s > n)
				left++; 
			else
				right++;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	int a = Integer.parseInt(br.readLine());  
    	int index = 1;
    	for (int i = 0; i < a; i++) {
    		int num = Integer.parseInt(br.readLine()); 
    		int ans = make(num);
    		System.out.println("#" + index + " " + ans);
    		index++;
    	}
    }
}