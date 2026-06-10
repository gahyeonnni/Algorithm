import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] a) {
        int answer = 0; 
        int n = a.length;
        
        int [] left = new int [n]; 
        int [] right = new int [n]; 
        
        left[0] = a[0]; 
        for (int i = 1; i < n; i++)
            left[i] = Math.min(a[i], left[i - 1]); 
        
        right[n - 1] = a[n - 1]; 
        for (int j = n - 2; j >= 0; j--)
            right[j] = Math.min(a[j],  right[j + 1]); 
        
        for (int i = 0; i < n; i++)
            if (a[i] <= left[i] || a[i] <= right[i])
                answer++; 
        
        return answer;
    }
}