import java.io.*;
import java.util.*;

public class Solution {
	static double answer;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	for (int i = 0; i < t; i++) {
    		int x = Integer.parseInt(br.readLine()); 
    		System.out.println("#" + (i + 1) + " " + x / 3);
    	}
    }
}
