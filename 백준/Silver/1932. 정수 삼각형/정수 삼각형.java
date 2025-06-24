import java.io.*;
import java.util.*;

public class Main {
	static int [] num;
	static int [] num2;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int a = Integer.parseInt(br.readLine());
    	num = new int [a+1];
    	num2 = new int [a+1];
    	int sum = 0;
    	int x = 0;
    	
    	st = new StringTokenizer(br.readLine());
        num2[0] = Integer.parseInt(st.nextToken()); 
        sum = num2[0]; 
        
    	for(int i = 2; i <= a; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < i; j++) {
    			int q = Integer.parseInt(st.nextToken());
    			if (j == 0) {
                    num[j] = num2[j] + q;
                } 
    			else if (j == i - 1) {
                    num[j] = num2[j - 1] + q;
                } 
    			else {
                    num[j] = Math.max(num2[j - 1], num2[j]) + q;
                }
    		}
    		System.arraycopy(num, 0, num2, 0, i);
    	}
    	for (int i = 0; i < a; i++) {
            sum = Math.max(sum, num2[i]);
        }
        
        System.out.println(sum); 
    }
}