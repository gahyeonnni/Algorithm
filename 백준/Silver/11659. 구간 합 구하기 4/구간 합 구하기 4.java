import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken());
	     int [] num = new int [N+1];
	     st = new StringTokenizer(br.readLine());
	     for (int i = 1; i <= N; i++) {
	    	 int a = Integer.parseInt(st.nextToken());
	    	 num[i] = num[i-1] + a;
	     }
	     for (int i = 0; i < M; i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 int q = Integer.parseInt(st.nextToken());
	    	 int x = Integer.parseInt(st.nextToken());
	    	 int sum = num[x] - num[q-1];
	    	 System.out.println(sum);
	     }
	 }
} 