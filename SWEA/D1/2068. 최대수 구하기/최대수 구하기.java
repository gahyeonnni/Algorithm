import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int num = Integer.parseInt(br.readLine());
    	List <int []> list = new ArrayList<>(); 
    	
    	for (int i = 0; i < num; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int [] array = new int [10]; 
    		for (int j = 0; j < 10; j++) {
    			array[j] = Integer.parseInt(st.nextToken());
    		}
    		list.add(array);
    	} 

    	int index = 1;
    	for (int [] x : list) {
    		int max = 0; 
    		for (int a : x) {
    			max = Math.max(max, a);
    		}
    		System.out.println("#" + index + " " + max);
    		index++;
    	}
    }
}
