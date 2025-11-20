import java.io.*;
import java.util.*;

public class Solution {
    static String[][] array;

    static int howmany(String [][] array, int len) {
    	int answer = 0;
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8 - len + 1; j++) {
    			String p = "";
    			for (int k = j; k < j + len; k++) {
    				p += array[i][k];
    			} 
    			
    			boolean ok = true;
    			for (int m = 0; m < len / 2; m++) {
    				if (p.charAt(m) != p.charAt(len - m - 1)) {
    					ok = false; 
    					break;
    				}
    			}
    			if (ok)
    				answer++;
    		}
    	}
    	
    	for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8 - len; j++) {
                String p = "";
                for (int k = j; k < j + len; k++)
                    p += array[k][i];

                boolean ok = true;
                for (int k = 0; k < len / 2; k++) {
                    if (p.charAt(k) != p.charAt(len - 1 - k)) {
                        ok = false;
                        break;
                    }
                }

                if (ok)
                    answer++;
            }
        }

    	return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            array = new String[8][8];

            for (int i = 0; i < 8; i++) {
                String s = br.readLine();
                for (int j = 0; j < 8; j++)
                    array[i][j] = s.substring(j, j + 1);
            }

            int ans = howmany(array, len);
            System.out.println("#" + t + " " + ans);
        }
    }
}
