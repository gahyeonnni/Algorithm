import java.util.*;

class Solution {
    public int solution(int[] cit) {
        int answer = 0;
        Arrays.sort(cit);
        int index = 0;
        while (index <= cit[cit.length - 1]){
            int count = 0;
            for (int i : cit)
                if (i >= index)
                    count++;
            if (count >= index)
                index++;
            else
                break;
        }
        return index - 1;
    }
}