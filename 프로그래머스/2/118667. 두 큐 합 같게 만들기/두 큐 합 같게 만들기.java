import java.util.*;

class Solution {
    public int solution(int[] queue4, int[] queue5) {
        int answer = 0;

        Queue<Long> queue1 = new LinkedList<>();
        Queue<Long> queue2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int num : queue4) {
            queue1.add((long) num);
            sum1 += num;
        }
        for (int num : queue5) {
            queue2.add((long) num);
            sum2 += num;
        }

        long target = (sum1 + sum2) / 2; 
        int max = queue4.length + queue5.length;

        while (answer <= max * 2) {
            if (sum1 == target) {
                return answer; 
            }

            if (sum1 > target) {
                long moved = queue1.poll();
                queue2.add(moved);
                sum1 -= moved;
                sum2 += moved;
            } 
            else {
                long moved = queue2.poll();
                queue1.add(moved);
                sum2 -= moved;
                sum1 += moved;
            }
            answer++;
        }

        return -1; 
    }
}
