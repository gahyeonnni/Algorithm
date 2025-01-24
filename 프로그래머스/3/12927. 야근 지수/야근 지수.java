import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        
        Arrays.sort(works);
        
        for (int i = 0; i < works.length; i++){
            sum += works[i];
        }
        
        if (n >= sum){
            return 0;
        }
        
        while (n > 0){
            works[works.length - 1]--;
            n--;
            
            for (int i = works.length - 1; i > 0; i--){
                if (works[i] < works[i-1]){
                    int temp = works[i];
                    works[i] = works[i - 1];
                    works[i - 1] = temp; 
                }
                else
                    break;
            }
        }
            
            long answer = 0;
            
            for (int i = 0; i < works.length; i++){
                answer += (long) works[i] * works[i];
            }
            
            return answer;
            
    }
}