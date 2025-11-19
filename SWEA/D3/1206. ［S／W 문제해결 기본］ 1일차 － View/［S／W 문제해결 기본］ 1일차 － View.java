import java.io.*;
import java.util.*;

public class Solution {   
	static int makeCount(int [] array, int num) {
		int ans = 0;
		for (int i = 2; i < num - 2; i++) {
			int lefta = array[i - 2]; 
			int leftb = array[i - 1]; 
			int max = Math.max(lefta, leftb); 
			int righta = array[i + 2]; 
			int rightb = array[i + 1]; 
			int max2 = Math.max(righta, rightb); 
			int max3 = Math.max(max2, max); 
			if (max3 > array[i])
			{
				continue;
			}
			int k = array[i] - max3;
			ans += k;  
		}
		return ans;
	}
    public static void main(String[] args) throws IOException { 
    	int index = 1; 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	for (int i = 0; i < 10; i++) {
    		int num = Integer.parseInt(br.readLine()); 
    		StringTokenizer st = new StringTokenizer(br.readLine()); 
    		int [] array = new int [num];  
    		for (int j = 0; j < num; j++) {
    			array[j] = Integer.parseInt(st.nextToken());
    		} 
    		int ans = makeCount(array, num); 
    		System.out.println("#" + index + " " + ans);
    		index++;
    	}
    }
}
