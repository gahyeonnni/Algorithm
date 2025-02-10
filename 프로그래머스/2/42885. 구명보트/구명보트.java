import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        for (int i = people.length - 1; i >= 0; i--){
            if (index > i)
                break;
            if (people[i] + people[index] > limit)
                answer++;
            else{
                index++;
                answer++;
            }
        }
        
        return answer;
    }
}