import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int n) {
        int answer = 0;
        int [] num = new int [n]; 
        num[0] = 1; 
        num[1] = 2; 
        for (int i = 2; i < num.length; i++) {
            num[i] = (num[i-1] + num[i-2]) % 1000000007;
        }
        return num[num.length - 1];
    }
}

//1개 -> 1개 
//2개 -> 2개 
//3개 -> 3개 
//4개 -> 5개 
//5개 -> 