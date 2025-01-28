import java.util.*;

class Solution {

    public int isPrime(long a) {
        if (a <= 1) return 1;
        for (long i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return 1;
        }
        return 0;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String knum = Integer.toString(n, k);

        String [] term = knum.split("0");
        
        for (String data : term){
            if (data.equals("")) continue;
            long num=Long.parseLong(data);                       
            if(isPrime(num) == 0){
                answer++;
            }
        }

        return answer;
    }
}
