import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	int a = Integer.parseInt(br.readLine());  
    	for (int i = 1; i <= a; i++) {
    		if (a % i == 0) {
    			System.out.print(i + " ");
    		}
    	}
    }
}
