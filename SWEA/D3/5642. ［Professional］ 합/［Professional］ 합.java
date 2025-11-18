import java.io.*;
import java.util.*;

public class Solution {    
    
    static int sum (int [] array, int a, int b) {
        int sum = 0; 
        for (int i = a; i <= b; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    static int make (int [] array, int num) {
        int max = array[0];       
        int current = array[0];            
        for (int i = 1; i < num; i++) {
            if (current < 0) {
                current = array[i];
            } 
            else {
                current += array[i];
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int a = Integer.parseInt(br.readLine()); 
        int index = 1;
        
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(br.readLine()); 
            int [] array = new int [num];  
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            
            for (int j = 0; j < num; j++) { 
                array[j] = Integer.parseInt(st.nextToken());
            } 
            
            int max = make(array, num); 
            System.out.println("#" + index + " " + max); 
            index++; 
        }
    }
}
