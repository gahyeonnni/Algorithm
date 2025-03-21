import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = 1;
        int[] copy = Arrays.copyOf(diffs, diffs.length);
        Arrays.sort(copy);
        int max = copy[copy.length - 1];
        while (min < max) {
            long sum = 0;
            int mid = (min + max) / 2;
            for (int i = 0; i < diffs.length; i++) {
                int cur_diff = diffs[i];
                if (mid >= cur_diff)
                    sum += times[i];
                else {
                    int num = diffs[i] - mid;
                    if (i == 0)
                        sum += num * (times[i] + 0) + times[i];
                    else
                        sum += num * (times[i] + times[i - 1]) + times[i];
                }
            }
            if (sum <= limit){
                max = mid;
            }
            else
                min = mid + 1;
        }
        return max;
    }
}