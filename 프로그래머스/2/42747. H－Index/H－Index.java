import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] cit) {
        int answer = 0;
        Arrays.sort(cit);
        for (int i = 0; i < cit[cit.length - 1]; i++){
            int num = 0;
            for (int j = 0; j < cit.length; j++){
                if (cit[j] >= i)
                    num++;
            }
            if (num >= i)
                answer = Math.max(answer, i);
        }
        return answer;
    }
}