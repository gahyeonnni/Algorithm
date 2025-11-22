import java.io.*;
import java.util.*;

public class Solution {
	static int answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String x = st.nextToken();

            int sum = 0;
            for (int i = 0; i < x.length(); i++) {
                sum += (x.charAt(i) - '0');
            }

            int result = sum % (n - 1);
            System.out.println("#" + (j + 1) + " " + result);
        }
    }
}

