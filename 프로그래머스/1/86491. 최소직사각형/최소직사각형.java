import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max1 = sizes[0][0];
        int max2 = sizes[0][1];
        int [] size = new int [sizes.length];
        for (int i = 1; i < sizes.length; i++){
            if (sizes[i][0] > max1)
                max1 = sizes[i][0];
            if (sizes[i][1] > max2)
                max2 = sizes[i][1];
        }
        for (int i = 0; i < sizes.length; i++){
            int a = Math.min(sizes[i][0], sizes[i][1]);
            size[i] = a;
        }
        int max3 = size[0];
        for (int i = 1; i < size.length; i++) {
            if (max3 < size[i])
                max3 = size[i];
        }
        int fmax = Math.max(max1, max2);
        answer = fmax * max3;
        return answer;
    }
}