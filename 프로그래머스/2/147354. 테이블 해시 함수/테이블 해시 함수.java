import java.io.*;
import java.util.*;

class Solution {
     public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
         
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[col - 1] == b[col - 1])
                    return b[0] - a[0];
                else
                    return a[col - 1] - b[col - 1];
            }
        });
         
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int val : data[i]) {
                sum += val % (i + 1);
            }
            answer ^= sum;
        }
         
        return answer;
    }
}