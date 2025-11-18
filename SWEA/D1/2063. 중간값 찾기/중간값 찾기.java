import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int num = Integer.parseInt(br.readLine());
    	int [] array = new int [num]; 
    	StringTokenizer st = new StringTokenizer(br.readLine()); 
    	for (int i = 0; i < num; i++) {
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(array); 
    	System.out.println(array[num / 2]);
    }
}
