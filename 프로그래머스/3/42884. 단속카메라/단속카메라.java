import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int x = Integer.MIN_VALUE;
        int answer = 0;

        for (int[] route : routes) {
            int a = route[0];
            int b = route[1];

            if (a > x) {
                answer++;
                x = b; 
            }
        }

        return answer;
    }
}
