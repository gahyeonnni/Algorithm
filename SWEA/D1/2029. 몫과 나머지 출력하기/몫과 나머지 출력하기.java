import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	int num = Integer.parseInt(br.readLine()); 
    	List <int []> list = new ArrayList<>();  
    	for (int i = 0; i < num; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());  
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		list.add(new int [] {a, b});
    	} 
    	int index = 1;
    	for (int [] x : list) {
    		int p = x[0]; 
    		int q = x[1]; 
    		int sp = p / q; 
    		int sq = p % q; 
    		System.out.println("#" + index + " " + sp + " " + sq);
    		index++;
    	}
    }
}
