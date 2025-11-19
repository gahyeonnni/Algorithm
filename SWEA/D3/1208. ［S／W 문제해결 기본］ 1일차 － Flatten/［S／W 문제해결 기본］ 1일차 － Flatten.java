import java.io.*;
import java.util.*;

public class Solution {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
        	int num = Integer.parseInt(br.readLine()); 
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	List <Integer> list = new ArrayList<>();
        	while (st.hasMoreTokens()) {
        		list.add(Integer.parseInt(st.nextToken()));
        	} 
        	int [] array = list.stream().mapToInt(i -> i).toArray();
        	while (num-- > 0) {
        		Arrays.sort(array); 
        		array[array.length - 1]--; 
        		array[0]++;
        	}
        	Arrays.sort(array); 
        	int answer = array[array.length - 1] - array[0];
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}
