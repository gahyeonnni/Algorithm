import java.io.*; 
import java.util.*; 

class Solution {
    static long maxsum(int [] array) {
        long cur = array[0];
        long max = array[0]; 
        
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(array[i], cur + array[i]); 
            max = Math.max(max, cur);
        }
        
        return max;
    }
    public long solution(int[] sequence) {
        long answer = 0;
        int [] copy1 = Arrays.copyOf(sequence, sequence.length); 
        int cur = 1;
        for (int i = 0; i < copy1.length; i++) {
            copy1[i] = copy1[i] * cur; 
            cur *= -1;
        }
        int [] copy2 = Arrays.copyOf(sequence, sequence.length); 
        cur = -1;
        for (int i = 0; i < copy1.length; i++) {
            copy2[i] = copy2[i] * cur; 
            cur *= -1;
        } 
        
        long max1 = maxsum(copy1); 
        long max2 = maxsum(copy2); 
        
        return Math.max(max1, max2);
    }
}