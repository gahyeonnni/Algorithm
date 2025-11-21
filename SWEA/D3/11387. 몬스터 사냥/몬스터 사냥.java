import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	int d = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	int sum = 0; 
        	for (int k = 0; k < n; k++)
        		sum += d + (d * k * l) / 100;
        	System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
