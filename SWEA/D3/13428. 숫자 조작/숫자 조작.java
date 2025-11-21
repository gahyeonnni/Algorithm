import java.io.*;
import java.util.*;

public class Solution {
	static String answer; 
	static void makenum(int [] array, List <Integer> list, int len) {
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;

	            int value = 0;
	            for (int k = 0; k < len; k++) {
	                value = value * 10 + array[k];
	            }
	            list.add(value);

	            temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	String s = br.readLine(); 
        	int len = s.length();
        	if (len == 1) {
        		System.out.println("#" + (j + 1) + " " + s + " " + s);
        		continue;
        	}
        	
        	int[] array = new int[len];
            for (int i = 0; i < len; i++)
                array[i] = s.charAt(i) - '0';

            int original = Integer.parseInt(s);

            List<Integer> list = new ArrayList<>();
            list.add(original);

            makenum(array, list, len);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int v : list) { 
            	if (String.valueOf(v).length() != len) {
            		continue;
            	}
                min = Math.min(min, v);
                max = Math.max(max, v);
            }

            System.out.println("#" + (j + 1) + " " + min + " " + max);
        }
    }
}
