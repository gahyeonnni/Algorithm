import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        for (int i = 0; i < answer.length; i++){
            int [] check = commands[i];
            int [] makenum = new int [check[1] - check[0] + 1];
            int index = 0;
            for (int j = (check[0] - 1); j < check[1]; j++){
                makenum[index++] = array[j];
            }
            Arrays.sort(makenum);
            answer[i] = makenum[check[2] - 1];
        }
        return answer;
    }
}