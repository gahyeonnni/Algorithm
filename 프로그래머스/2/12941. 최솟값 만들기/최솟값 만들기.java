import java.io.*;   
import java.util.*; 

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        if (A[A.length - 1] > B[B.length - 1]){
            for (int i = 0; i < A.length; i++){
                answer += A[A.length - 1 - i] * B[i];
            }
        }
        else{
             for (int i = 0; i < A.length; i++){
                answer += B[A.length - 1 - i] * A[i];
            }
        }
        return answer;
    }
}